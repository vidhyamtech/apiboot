package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import apiClasses.UserApi;
import io.cucumber.java.en.*;

public class PostStepDefinition {
	UserApi objApi= new UserApi();

@Given("Create a user with valid endpoint")
public void create_a_user_with_valid_endpoint() throws IOException {
	objApi.setUserGetEndpoint("POST");
}

@When("user send http post request")
public void user_send_http_post_request() throws InvalidFormatException, IOException {
	objApi.postRequest();
}

@Then("user gets valid response body for post")
public void user_gets_valid_response_body_for_post() {
	int rs =201;
	objApi.verifyStatusCode(rs);
}

}
