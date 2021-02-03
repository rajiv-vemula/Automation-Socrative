package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/java/resources/Features/SmokeTest.feature"},
			glue = {"StepDefinitions"},
			tags = "@Smokey or @Regression",
			plugin = {"pretty"}
		)

public class SocrativeRunner {
	

}
