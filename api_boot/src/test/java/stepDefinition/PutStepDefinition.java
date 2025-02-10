package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import apiClasses.UserApi;
import io.cucumber.java.en.*;

public class PutStepDefinition {
	UserApi objApi= new UserApi();

@Given("update a user with valid endpoint")
public void update_a_user_with_valid_endpoint() throws IOException {
	objApi.setUserGetEndpoint("PUT");
}

@When("user send http put request")
public void user_send_http_put_request() throws InvalidFormatException, IOException {
	objApi.putRequest("PUT");
}

@Then("user gets valid response body for put")
public void user_gets_valid_response_body_for_put() {
	int rs =200;
	objApi.verifyStatusCode(rs);
}

}
