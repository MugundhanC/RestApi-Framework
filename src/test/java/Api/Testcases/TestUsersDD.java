package Api.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Api.Endpoints.UserEndpoints;
import Api.Payloads.Users;
import Api.Utilities.Dataproviders;
import io.restassured.response.Response;

public class TestUsersDD {
	
	Users userpayloaddata;
	
	@Test(priority=1,dataProvider="data",dataProviderClass=Dataproviders.class)
	public void postusers(String userdata[])
{
		userpayloaddata=new Users();
		
		userpayloaddata.setId(Integer.parseInt(userdata[0]));
		userpayloaddata.setUsername(userdata[1]);
		userpayloaddata.setFirstName(userdata[2]);
		userpayloaddata.setLastName(userdata[3]);
		userpayloaddata.setEmail(userdata[4]);
		userpayloaddata.setPassword(userdata[5]);
		userpayloaddata.setPhone(userdata[6]);
		
		Response ures=UserEndpoints.CreateUsers(userpayloaddata);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider="username",dataProviderClass=Dataproviders.class)
	public void Getusers(String uname) {
		Response gres=UserEndpoints.GetUsers(uname);
		gres.then().log().all();
		Assert.assertEquals(gres.getStatusCode(), 200);	
	}
	
	@Test(priority=3,dataProvider="username",dataProviderClass=Dataproviders.class)
	public void Putusers(String uname) {
		userpayloaddata.setEmail("Mugu@gmail.com");
		userpayloaddata.setPassword("Mugu");
		userpayloaddata.setPhone("85336524");
		
		Response pres=UserEndpoints.PutUsers(userpayloaddata, uname);
		pres.then().log().all();
		Assert.assertEquals(pres.getStatusCode(), 200);
		
		//check the data
		Response cres=UserEndpoints.GetUsers(uname);
		cres.then().log().all();
	}
	
	@Test(priority=4,dataProvider="username",dataProviderClass=Dataproviders.class )
	public void Deleteusers(String uname) {
		
		Response dres=UserEndpoints.DeleteUsers(uname);
		dres.then().log().all();
		Assert.assertEquals(dres.getStatusCode(), 200);
	}

}
