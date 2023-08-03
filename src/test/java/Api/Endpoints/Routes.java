package Api.Endpoints;

public class Routes {
	
	public static String BaseURL="https://petstore.swagger.io/v2"; 
	
	//User Module End points:
	public static String user_PostURL=BaseURL+"/user";
	public static String user_GetURL=BaseURL+"/user/{username}";
	public static String user_PutURL=BaseURL+"/user/{username}";
	public static String user_DeleteURL=BaseURL+"/user/{username}";

}
