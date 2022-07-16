package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.api.context.TestContext;
import com.api.test.TestBase;
import com.api.utils.PropertiesCache;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GetAPI extends TestBase{
	
	TestContext testContext;
	
	public GetAPI(TestContext tContext) {
		this.testContext = tContext;
	}
	
	
	String baseurl = PropertiesCache.getInstance().getProperty("baseuri");
	
	@Given("set the base url as {string}")
	public void set_the_base_url_as(String string) {
		String baseurl = PropertiesCache.getInstance().getProperty(string);
		testContext.scenario.log("Base URL is : " +baseurl);
	}

	@Given("user hit get api {string}")
	public void user_hit_get_api(String endpoint) {
		
		testContext.response = given().baseUri(baseurl).when().get(endpoint);
		testContext.scenario.log(testContext.scenario.getName());
		testContext.scenario.log(testContext.response.asPrettyString());
	}

	@When("verify response code should be {int}")
	public void verify_response_code_should_be(int responsecode) {
		
		testContext.response.then().assertThat().statusCode(responsecode);
		testContext.scenario.log("Response code verification is : " + testContext.response.statusCode());
	}

	@When("response should have value {string} at {string}")
	public void response_should_have_value_at(String expected, String jsonpath) {
		testContext.response.then().assertThat().body(jsonpath, equalTo(expected));
	}
	
	@When("response should have value {int} at {string}")
	public void response_should_have_value_at(int expected, String jsonpath) {
		testContext.response.then().assertThat().body(jsonpath, equalTo(expected));
	}
}
