package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/java/resources/Features/SmokeTest.feature"},
			glue = {"stepDefinitions" , "appHooks"},
			tags = "not @Regression",
			plugin = {"pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"timeline:test-output-thread/"},
			monochrome =true
		)
public class SmokeTestRunner {

}
