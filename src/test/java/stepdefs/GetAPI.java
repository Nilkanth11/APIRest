package stepdefs;

import com.api.context.TestContext;
import com.api.test.TestBase;
import com.api.utils.PropertiesCache;

import io.cucumber.java.en.Given;

public class GetAPI extends TestBase{
	
	TestContext testContext;
	
	public GetAPI(TestContext tContext) {
		this.testContext = tContext;
	}
	
	
	@Given("set the base url as {string}")
	public void set_the_base_url_as(String string) {
		String baseurl = PropertiesCache.getInstance().getProperty(string);
		testContext.scenario.log("Base URL is : " +baseurl);
	}

}
