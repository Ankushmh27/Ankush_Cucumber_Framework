package com.hotelcrm.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/com/hotelcrm/Features"},
		glue = {"com.hotelcrm.Stepdefination"},
		plugin = { "pretty", "json:target/json-report/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",}, 
		publish = true,
		tags = "@SuperAdmin_Login_Positive or @SuperAdmin_Login_Negative"
		)

public class TestRunner extends AbstractTestNGCucumberTests 
{

}
