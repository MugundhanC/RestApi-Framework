package Api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import Api.Payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	public static ResourceBundle geturl() {
		
		ResourceBundle resource=ResourceBundle.getBundle("AppRoutes");
		return resource;
	}
	
	public static Response CreateUsers(Users payload) {
		
		String url=geturl().getString("user_PostURL");
		
		Response res=given()
				        .contentType(ContentType.JSON)
				        .accept(ContentType.JSON)
				        .body(payload)
				      .when()
				        .post(url);
				 
		return res;	
	}

	public static Response GetUsers(String uname) {
		
		String Gurl=geturl().getString("user_GetURL");
		
		Response res=given()
				        .contentType(ContentType.JSON)
				        .accept(ContentType.JSON)
				        .pathParam("username", uname)
				      .when()
				        .get(Gurl);
		
		return res;
	}
	
	public static Response PutUsers(Users payload,String uname) {
		
		String Purl=geturl().getString("user_PutURL");
		
		Response res=given()
				        .contentType(ContentType.JSON)
				        .accept(ContentType.JSON)
				        .body(payload)
				        .pathParam("username", uname)
				      .when()
				        .put(Purl);
		
		
		return res;
	}
	
	public static Response DeleteUsers(String uname) {
		
		String Durl=geturl().getString("user_DeleteURL");
		
		  Response res=given()
				         .contentType(ContentType.JSON)
				         .accept(ContentType.JSON)
				         .pathParam("username", uname)
				       .when()
				         .delete(Durl);
		
		return res;
		
	}
}
