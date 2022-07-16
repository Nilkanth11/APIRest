package com.api.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "resources/features/" }, 
		glue = { "stepdefs","hooks"}, 
		plugin = {"pretty","html:target/html/cucumber-report.html","json:target/json/file.json"},
		//tags = "@get,@post",
		monochrome = true,
		dryRun = false
		
		)
public class MyTestRunner extends AbstractTestNGCucumberTests{
	
}
