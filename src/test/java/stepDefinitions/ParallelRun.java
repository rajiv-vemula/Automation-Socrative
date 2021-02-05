package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { "src/java/resources/Features/SmokeTest.feature" },
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				//"rerun:target/failedrerun.txt"
				}, 
		monochrome = true,
		glue = { "stepDefinitions" }
		
)

public class ParallelRun extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
}
