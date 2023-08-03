package Api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import Api.Payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response CreateUsers(Users payload) {
		
		Response res=given()
				        .contentType(ContentType.JSON)
				        .accept(ContentType.JSON)
				        .body(payload)
				      .when()
				        .post(Routes.user_PostURL);
				        
		
		return res;	
	}

	public static Response GetUsers(String uname) {
		
		Response res=given()
				        .contentType(ContentType.JSON)
				        .accept(ContentType.JSON)
				        .pathParam("username", uname)
				      .when()
				        .get(Routes.user_GetURL);
		
		return res;
	}
	
	public static Response PutUsers(Users payload,String uname) {
		
		Response res=given()
				        .contentType(ContentType.JSON)
				        .accept(ContentType.JSON)
				        .body(payload)
				        .pathParam("username", uname)
				      .when()
				        .put(Routes.user_PutURL);
		
		
		return res;
	}
	
	public static Response DeleteUsers(String uname) {
		
		  Response res=given()
				         .contentType(ContentType.JSON)
				         .accept(ContentType.JSON)
				         .pathParam("username", uname)
				       .when()
				         .delete(Routes.user_DeleteURL);
		
		return res;
		
	}
}
