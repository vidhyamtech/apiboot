package apiClasses;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
//import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.UserAddress;
import pojo.UserPojo;
import utilities.ExcelUtilities;

import static io.restassured.RestAssured.given;

public class UserApi {
	private Properties prop;
	private String baseURI;
	private String endPoint;
	private Response response;
	private int StatusCode;
	private String xlPath;
	String userId;
	int scode;

	public UserApi()
	{
		prop =new Properties();
		try {
			prop.load(UserApi.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		baseURI=prop.getProperty("baseURI");
	}

	public void setUserGetEndpoint(String operation) throws IOException
	{
		System.out.println(operation);
		if(operation.equalsIgnoreCase("GET"))

		{
			endPoint =baseURI+prop.getProperty("getByIdEndPoint");
		}
		else if(operation.equalsIgnoreCase("POST"))
		{
			endPoint =baseURI+prop.getProperty("postUserEndpoint");
		}
		else if(operation.equalsIgnoreCase("PUT"))
		{
			endPoint =baseURI+prop.getProperty("puttUserEndpoint");
		}
		else if(operation.equalsIgnoreCase("DELETE"))
		{
			endPoint =baseURI+prop.getProperty("deleteByIdEndpoint");
		}
		System.out.println(endPoint);
	}

	public void sendGetAllUser(String operation) throws InvalidFormatException, IOException {
		//response=given().log().all().auth().basic(prop.getProperty("username"),prop.getProperty("password")).get(endPoint);
		System.out.println(endPoint+"deletereq");
		ExcelUtilities xlutils =new ExcelUtilities();
		xlPath=prop.getProperty("xlPath");
		
	    List<Map<String, String>> data = xlutils.getData(xlPath, "Testdata","GET");
	    for (Map<String, String> row : data) {
	    	System.out.println("1");
	    	UserPut userpayload = new UserPut();
			UserAddress userAddress = new UserAddress();
		  userpayload.setUser_first_name(row.get("firstname"));
		  userpayload.setUser_last_name(row.get("lastname"));
		  userpayload.setUser_contact_number(row.get("contactno"));
		  userpayload.setUser_email_id(row.get("email"));
		  userAddress.setPlotNumber(row.get("plotno"));
		  userAddress.setStreet(row.get("street"));
		  userAddress.setState(row.get("state"));
		  userAddress.setCountry(row.get("country"));
		  userAddress.setZipCode(row.get("zipcode"));
		  if(operation.equalsIgnoreCase("GET"))
		  {
		  userpayload.setUser_id(row.get("user_id"));
		  endPoint = endPoint+row.get("user_id");
		  scode =Integer.parseInt(row.get("status"));
		  
		  }
		  if(operation.equalsIgnoreCase("CRUD"))
		  {
			  userpayload.setUser_id(userId); 
			  endPoint = endPoint+userId;
			  int rs= 200;
			  scode=200;
		  }
		  System.out.println(endPoint);
		  userpayload.setUserAddress (userAddress);
		 
		  response=given().log().all().auth().basic(prop.getProperty("username"),prop.getProperty("password")).when().contentType(ContentType.JSON).get(endPoint);
		 
		 System.out.println( response.getBody().asString());
		 
		  if(response.statusCode()==scode)
		  {
		 JsonPath jsonPath = response.jsonPath();
		   userId =String.valueOf(jsonPath.getInt("user_id"));
		System.out.println(userId);
		  }
	    }
	}

	public void verifyStatusCode(int expectedStatusCode)
	{
		StatusCode=response.getStatusCode();
		Assert.assertEquals(StatusCode,expectedStatusCode);
		System.out.println("matching");
	}
	public void verifyHeader1()
	{
		response.then().assertThat().contentType(ContentType.JSON);
		System.out.println("response is in json");
	}

	public String postRequest() throws InvalidFormatException, IOException
	{
		String userID =null;

		ExcelUtilities xlutils =new ExcelUtilities();
		xlPath=prop.getProperty("xlPath");

		List<Map<String, String>> data = xlutils.getData(xlPath, "Testdata","POST");
		for (Map<String, String> row : data) {
			UserPojo userpayload = new UserPojo();
			UserAddress userAddress = new UserAddress();
			userpayload.setUser_first_name(row.get("firstname"));
			userpayload.setUser_last_name(row.get("lastname"));
			userpayload.setUser_contact_number(row.get("contactno"));
			userpayload.setUser_email_id(row.get("email"));
			userAddress.setPlotNumber(row.get("plotno"));
			userAddress.setStreet(row.get("street"));
			userAddress.setState(row.get("state"));
			userAddress.setCountry(row.get("country"));
			userAddress.setZipCode(row.get("zipcode"));
			userpayload.setUserAddress (userAddress);

			 response=given().log().all().auth().basic(prop.getProperty("username"),prop.getProperty("password")).when().contentType(ContentType.JSON).body(userpayload).post(endPoint).then().extract().response();

			System.out.println( response.getBody().asString());
			scode =Integer.parseInt(row.get("status"));
			if(response.statusCode()==scode)
			{
				JsonPath jsonPath = response.jsonPath();
				int userId = jsonPath.getInt("user_id");
				System.out.println(userId);
			}
		}
		return userID;
	}
	
		
	public void putRequest(String operation) throws InvalidFormatException, IOException
	{
		
		ExcelUtilities xlutils =new ExcelUtilities();
		xlPath=prop.getProperty("xlPath");
		
	    List<Map<String, String>> data = xlutils.getData(xlPath, "Testdata","PUT");
	    for (Map<String, String> row : data) {
	    	UserPut userpayload = new UserPut();
			UserAddress userAddress = new UserAddress();
		  userpayload.setUser_first_name(row.get("firstname"));
		  userpayload.setUser_last_name(row.get("lastname"));
		  userpayload.setUser_contact_number(row.get("contactno"));
		  userpayload.setUser_email_id(row.get("email"));
		  userAddress.setPlotNumber(row.get("plotno"));
		  userAddress.setStreet(row.get("street"));
		  userAddress.setState(row.get("state"));
		  userAddress.setCountry(row.get("country"));
		  userAddress.setZipCode(row.get("zipcode"));
		  if(operation.equalsIgnoreCase("PUT"))
		  {
		  userpayload.setUser_id(row.get("user_id"));
		  scode =Integer.parseInt(row.get("status"));
		  }
		  if(operation.equalsIgnoreCase("CRUD"))
		  {
			  userpayload.setUser_id(userId);  
			  int rs= 200;
			  scode=200;
		  }
		  userpayload.setUserAddress (userAddress);
		  
		 Response response1=given().log().all().auth().basic(prop.getProperty("username"),prop.getProperty("password")).when().contentType(ContentType.JSON).body(userpayload).put(endPoint).then().extract().response();
		 
		 System.out.println( response1.getBody().asString());
		 
		  if(response1.statusCode()==scode)
		  {
		 JsonPath jsonPath = response1.jsonPath();
		   userId =String.valueOf(jsonPath.getInt("user_id"));
		System.out.println(userId);
		  }
	    }
	}
	
	public void deleteRequest(String operation) throws InvalidFormatException, IOException
	{
		 System.out.println(endPoint+"deletereq");
		ExcelUtilities xlutils =new ExcelUtilities();
		xlPath=prop.getProperty("xlPath");
		
	    List<Map<String, String>> data = xlutils.getData(xlPath, "Testdata","DELETE");
	    for (Map<String, String> row : data) {
	    	System.out.println("1");
	    	UserPut userpayload = new UserPut();
			UserAddress userAddress = new UserAddress();
		  userpayload.setUser_first_name(row.get("firstname"));
		  userpayload.setUser_last_name(row.get("lastname"));
		  userpayload.setUser_contact_number(row.get("contactno"));
		  userpayload.setUser_email_id(row.get("email"));
		  userAddress.setPlotNumber(row.get("plotno"));
		  userAddress.setStreet(row.get("street"));
		  userAddress.setState(row.get("state"));
		  userAddress.setCountry(row.get("country"));
		  userAddress.setZipCode(row.get("zipcode"));
		  if(operation.equalsIgnoreCase("DELETE"))
		  {
		  userpayload.setUser_id(row.get("user_id"));
		  endPoint = endPoint+row.get("user_id");
		  scode =Integer.parseInt(row.get("status"));
		  }
		  if(operation.equalsIgnoreCase("CRUD"))
		  {
			  userpayload.setUser_id(userId); 
			  endPoint = endPoint+userId;
			  int rs= 200;
			  scode=200;
		  }
		  System.out.println(endPoint);
		  userpayload.setUserAddress (userAddress);
		 
		  response=given().log().all().auth().basic(prop.getProperty("username"),prop.getProperty("password")).when().contentType(ContentType.JSON).delete(endPoint);
		 
		 System.out.println( response.getBody().asString());
		 
		  if(response.statusCode()==scode)
		  {
		 JsonPath jsonPath = response.jsonPath();
		   userId =String.valueOf(jsonPath.getInt("user_id"));
		System.out.println(userId);
		  }
	    }
	}


}

