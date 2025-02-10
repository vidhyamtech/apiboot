package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import apiClasses.UserApi;
import io.cucumber.java.en.*;

public class CrudStepDefinition {
	UserApi objApi= new UserApi();

@Given("Create a user with valid all endpoint")
public void create_a_user_with_valid_all_endpoint() throws IOException {
	objApi.setUserGetEndpoint("POST");
}

@When("user send http request")
public void user_send_http_request() throws InvalidFormatException, IOException {
	objApi.postRequest("CRUD");
	objApi.setUserGetEndpoint("PUT");
	objApi.putRequest("CRUD");
	objApi.setUserGetEndpoint("GET");
	objApi.sendGetAllUser("CRUD");
	objApi.setUserGetEndpoint("DELETE");
	objApi.deleteRequest("CRUD");
}

@Then("user gets valid response body for all")
public void user_gets_valid_response_body_for_all() {
	//int rs =200;
	objApi.verifyStatusCode(200);
}

}
