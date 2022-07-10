package com.api.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/AppFeatures/" }, 
		glue = { "stepdefinitions", "AppHooks" }, 
		plugin = {"pretty","html:target/cucumber-reports"},
		monochrome = true
		)
public class MyTestRunner extends AbstractTestNGCucumberTests{
	
}
