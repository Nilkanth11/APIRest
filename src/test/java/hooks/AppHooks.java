
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {


	@Before(order = 0)
	public void getProperty() {
	}

	@Before(order = 1)
	public void lunchBrowser() {
	}

	@After(order = 0)
	public void quitBrowser() {
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
	}
}
