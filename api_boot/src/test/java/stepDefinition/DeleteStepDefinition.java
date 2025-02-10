package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import apiClasses.UserApi;
import io.cucumber.java.en.*;

public class DeleteStepDefinition {
UserApi objApi= new UserApi();

@Given("user sets the baseurl and endpoint for delete {string}")
public void user_sets_the_baseurl_and_endpoint_for_delete(String string) throws IOException {
	objApi.setUserGetEndpoint(string);
}

@When("user send http delete request")
public void user_send_http_delete_request() throws InvalidFormatException, IOException {
	objApi.deleteRequest("DELETE");
}


@Then("user gets valid response body for delete")
public void user_gets_valid_response_body_for_delete() {
	int rs =200;
	//objApi.verifyStatusCode(rs);
}




	
	
	
}
