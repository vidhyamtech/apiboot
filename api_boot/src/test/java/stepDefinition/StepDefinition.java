package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import apiClasses.UserApi;
import io.cucumber.java.en.*;

public class StepDefinition {
UserApi objApi= new UserApi();

@Given("user sets the baseurl and endpoint for get {string}")
public void user_sets_the_baseurl_and_endpoint_for_get(String string) throws IOException {
	objApi.setUserGetEndpoint(string);
}

@When("user send http get request")
public void user_send_http_get_request() throws InvalidFormatException, IOException {
	objApi.sendGetAllUser("GET");
}


@Then("user gets valid response body for get")
public void user_gets_valid_response_body_for_get() {
	objApi.verifyStatusCode(200);
}




	
	
	
}
