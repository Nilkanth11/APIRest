package hooks;

import com.api.context.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext tContext) {
		this.testContext = tContext;
	}
	
	@Before
	public void setUp(Scenario s) {
		this.testContext.scenario = s;
	}

	@After
	public void cleanUp() {
		testContext.request = null;
		testContext.response = null;
	}
}
