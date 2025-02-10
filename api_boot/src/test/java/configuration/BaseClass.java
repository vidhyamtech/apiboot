package configuration;

import java.io.IOException;
import java.util.Properties;

import apiClasses.UserApi;
import io.restassured.response.Response;

public class BaseClass {
	private Properties prop;
	private String baseURI;
	private String endPoint;
	private Response response;
	private int StatusCode;
	private String xlPath;
	String userId;
	int scode;

	public BaseClass()
	{
		prop =new Properties();
		try {
			prop.load(UserApi.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		baseURI=prop.getProperty("baseURI");
	}
	
	public String getUserName()
	{
		String username =prop.getProperty("username");
		String password=prop.getProperty("password");
		return username;
	}
	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
}
