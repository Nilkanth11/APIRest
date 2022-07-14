package stepdefs;

import com.api.utils.PropertiesCache;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class GetAPI {
	
	private RequestSpecBuilder request;
	private Response response;
	
	String baseurl = PropertiesCache.getInstance().getProperty("baseuri");
	
	Scenario scenario;
	
	@Before
	public void setUp(Scenario s) {
		this.scenario = s;
	}

	@Given("set the base url as {string}")
	public void set_the_base_url_as(String string) {
		String baseurl = PropertiesCache.getInstance().getProperty(string);
		System.out.println("Base URL is :" + baseurl);
	}

	@Given("user hit get api {string}")
	public void user_hit_get_api(String endpoint) {
		
		response = given().baseUri(baseurl).when().get(endpoint);
		System.out.println(response.asPrettyString());
		System.out.println(scenario.getName());
		System.out.println("Scenario status : " +scenario.getStatus());
		scenario.log(response.asPrettyString());
	}

	@When("verify response code should be {int}")
	public void verify_response_code_should_be(int responsecode) {
		
		scenario.log("Response code verification is : " + response.statusCode());
	}

	@When("response should have value {string} at {string}")
	public void response_should_have_value_at(String expected, String jsonpath) {
		System.out.println("Verify value : " + expected + " at : " + jsonpath);
	}

}
