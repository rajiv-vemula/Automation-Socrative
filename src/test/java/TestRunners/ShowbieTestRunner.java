package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { "src/java/resources/Features/ShowbieSmokeTest.feature" },
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				}, 
		monochrome = true,
		glue = { "showbieStepDefinitions" }		
)

public class ShowbieTestRunner extends AbstractTestNGCucumberTests {
}
