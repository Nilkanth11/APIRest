package stepdefs;

import static io.restassured.RestAssured.given;

import com.api.context.TestContext;
import com.api.test.TestBase;
import com.api.utils.PropertiesCache;
import com.api.utils.RandomData;

import io.cucumber.java.en.Given;

public class PostAPI extends TestBase{
	
	TestContext testContext;
	
	public PostAPI(TestContext tContext) {
		this.testContext = tContext;
	}
	String baseurl = PropertiesCache.getInstance().getProperty("baseuri");
	
	@Given("user hit post api {string}")
	public void user_hit_post_api(String endpoint) {
		
		String name = RandomData.getRandomName(5);
		
		String bodyString = "{\"name\":\""+name+"\",\"salary\":\"123\",\"age\":\"23\"}";
		
		testContext.response = given().baseUri(baseurl).when().post(endpoint);
		testContext.scenario.log(bodyString);
		testContext.scenario.log(testContext.response.asPrettyString());
	}

}
