package com.api.context;

import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class TestContext {
	
	public RequestSpecBuilder request = null;
	public Response response = null;
	public Scenario scenario = null;

}
