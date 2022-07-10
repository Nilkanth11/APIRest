package com.api.get;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GetAPI {

	@Given("set the base url as {string}")
	public void set_the_base_url_as(String baseurl) {
		System.out.println("Base URL is :" +baseurl);
	}
	
	@Given("user hit get api")
	public void user_hit_get_api() {
		System.out.println("GET api hit");
	}

	@When("verify response code should be {int}")
	public void verify_response_code_should_be(int responsecode) {
		System.out.println("Response code verification is : " + responsecode);
	}

	@When("response should have value {string} at {string}")
	public void response_should_have_value_at(String expected, String jsonpath) {
		System.out.println("Verify value : " + expected +" at : " +jsonpath);
	}

}
