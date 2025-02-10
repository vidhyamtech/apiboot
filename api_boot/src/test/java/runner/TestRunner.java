package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/feature"},tags= "@CRUD and @GET and @POST and @PUT and @DELETE",glue={"stepDefinition"},
plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" } )
public class TestRunner extends AbstractTestNGCucumberTests{

}
