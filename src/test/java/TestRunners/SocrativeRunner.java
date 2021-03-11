package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { "src/java/resources/Features/CreateAccount.feature" },
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}, 
		monochrome = true,
		glue = { "stepDefinitions" }
		
)

public class SocrativeRunner extends AbstractTestNGCucumberTests {

}
