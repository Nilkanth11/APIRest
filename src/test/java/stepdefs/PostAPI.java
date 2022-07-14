package stepdefs;

import static io.restassured.RestAssured.given;

import com.api.test.TestBase;
import com.api.utils.PropertiesCache;
import com.api.utils.RandomData;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class PostAPI extends TestBase{
	
	
	String baseurl = PropertiesCache.getInstance().getProperty("baseuri");
	
	Scenario scenario;
	
	@Before
	public void setUp(Scenario s) {
		this.scenario = s;
	}
	
	
	@Given("user hit post api {string}")
	public void user_hit_post_api(String endpoint) {
		
		String name = RandomData.getRandomName(5);
		
		String bodyString = "{\"name\":\""+name+"\",\"salary\":\"123\",\"age\":\"23\"}";
		
		response = given().baseUri(baseurl).when().post(endpoint);
		scenario.log(bodyString);
		scenario.log(response.asPrettyString());
	}

}
