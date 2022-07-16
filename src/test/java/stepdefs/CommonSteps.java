package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.hamcrest.Matchers;

import com.api.context.TestContext;
import com.api.utils.PropertiesCache;
import com.jayway.jsonpath.JsonPath;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public final class CommonSteps {
	
	String baseurl = PropertiesCache.getInstance().getProperty("baseuri");

	TestContext testContext;

	public CommonSteps(TestContext t) {
		this.testContext = t;
	}
	
	@Given("user hit get api {string}")
	public void user_hit_get_api(String endpoint) {
		
		testContext.response = given().baseUri(baseurl).when().get(endpoint);
		testContext.scenario.log(testContext.scenario.getName());
		testContext.scenario.log(testContext.response.asPrettyString());
	}
	
	@When("response should have value {string} at {string}")
	public void response_should_have_value_at(String expected, String jsonpath) {

		Object actual = JsonPath.read(testContext.response.asString(), jsonpath);
		if (null != actual && Number.class.isAssignableFrom(actual.getClass())) {
			assertThat(new BigDecimal(String.valueOf(actual)),
					Matchers.equalTo(new BigDecimal(String.valueOf(expected))));
		} else {
			testContext.response.then().assertThat().body(jsonpath, equalTo(expected));
		}

	}

	@When("response should have status code {int}")
	public void response_should_have_status_code(int statuscode) {
		assertThat("Response status", testContext.response.getStatusCode(), equalTo(statuscode));
	}

	@When("response should have {string} jsonpath")
	public void response_should_have_jsonpath(String jsonpath) {
		testContext.response.then().assertThat().body(jsonpath, Matchers.hasItem(true));
	}

	@When("response should not have {string} jsonpath")
	public void response_should_not_have_jsonpath(String jsonpath) {
		testContext.response.then().assertThat().body(jsonpath, Matchers.hasItem(false));
	}

	@When("response should have value contains {string} at {string}")
	public void response_should_have_value_contains_at_jsonpath(String containsvalue, String jsonpath) {
		Object actual = JsonPath.read(testContext.response.asString(), jsonpath);
		assertThat("Response value contains", String.valueOf(actual), Matchers.containsString(containsvalue));
	}

	
	@When("response should have value ignoring case {string} at {string}")
	public void response_should_have_value_ignoring_case_at_jsonpath(String expected, String jsonpath) {
		Object actual = JsonPath.read(testContext.response.asString(), jsonpath);
		assertThat("Response value contains", String.valueOf(actual), Matchers.equalToIgnoringCase(expected));
	}
}
