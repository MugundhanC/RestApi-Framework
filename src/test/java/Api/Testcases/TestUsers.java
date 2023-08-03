package Api.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.Endpoints.UserEndpoints;
import Api.Payloads.Users;
import io.restassured.response.Response;

public class TestUsers {
	
	Faker fk;
	Users userpayloaddata;
	
	@BeforeClass
	public void setupdata() {
		
		fk=new Faker();
		userpayloaddata=new Users();
		
		userpayloaddata.setId(fk.idNumber().hashCode());
		userpayloaddata.setUsername(fk.name().username());
		userpayloaddata.setFirstName(fk.name().firstName());
		userpayloaddata.setLastName(fk.name().lastName());
		userpayloaddata.setEmail(fk.internet().emailAddress());
		userpayloaddata.setPassword(fk.internet().password(5, 10));
		userpayloaddata.setPhone(fk.phoneNumber().cellPhone());
		
	}
	@Test(priority = 1)
	public void postusers() {
		
		Response ures=UserEndpoints.CreateUsers(userpayloaddata);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void Getusers() {
		
		Response gres=UserEndpoints.GetUsers(userpayloaddata.getUsername());
		gres.then().log().all();
		Assert.assertEquals(gres.getStatusCode(), 200);	
	}
	
	@Test(priority = 3)
	public void Putusers() {
	
		userpayloaddata.setEmail(fk.internet().emailAddress());
		userpayloaddata.setPassword(fk.internet().password(5, 10));
		userpayloaddata.setPhone(fk.phoneNumber().cellPhone());
		
		Response pres=UserEndpoints.PutUsers(userpayloaddata, userpayloaddata.getUsername());
		pres.then().log().all();
		Assert.assertEquals(pres.getStatusCode(), 200);
		
		//Check the Data
		Response gres=UserEndpoints.GetUsers(userpayloaddata.getUsername());
		gres.then().log().all();
	}
	
	@Test(priority = 4)
	public void Deleteusers() {
		
		Response dres=UserEndpoints.DeleteUsers(userpayloaddata.getUsername());
		dres.then().log().all();
		Assert.assertEquals(dres.getStatusCode(), 200);
	}
	
	
	
}
