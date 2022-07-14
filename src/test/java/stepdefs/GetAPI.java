package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.api.test.TestBase;
import com.api.utils.PropertiesCache;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GetAPI extends TestBase{
	
	
	String baseurl = PropertiesCache.getInstance().getProperty("baseuri");
	
	Scenario scenario;
	
	@Before
	public void setUp(Scenario s) {
		this.scenario = s;
	}

	@Given("set the base url as {string}")
	public void set_the_base_url_as(String string) {
		String baseurl = PropertiesCache.getInstance().getProperty(string);
		scenario.log("Base URL is : " +baseurl);
	}

	@Given("user hit get api {string}")
	public void user_hit_get_api(String endpoint) {
		
		response = given().baseUri(baseurl).when().get(endpoint);
		scenario.log(scenario.getName());
		scenario.log(response.asPrettyString());
	}

	@When("verify response code should be {int}")
	public void verify_response_code_should_be(int responsecode) {
		
		response.then().assertThat().statusCode(responsecode);
		scenario.log("Response code verification is : " + response.statusCode());
	}

	@When("response should have value {string} at {string}")
	public void response_should_have_value_at(String expected, String jsonpath) {
		response.then().assertThat().body(jsonpath, equalTo(expected));
	}
	
	@When("response should have value {int} at {string}")
	public void response_should_have_value_at(int expected, String jsonpath) {
		response.then().assertThat().body(jsonpath, equalTo(expected));
	}
}
