package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.Factory.DriverFactory;
import com.pages.LaunchPage;

import io.cucumber.java.en.Then;

public class LaunchPageSteps {
	
	private LaunchPage launchPage;
	private WebDriver driver;
	private SoftAssert softAssert;
	
	public LaunchPageSteps()
	{
		driver = DriverFactory.getDriver();
		launchPage = new LaunchPage(driver);
		softAssert = new SoftAssert();
	}

	@Then("Teacher verifies the control is in the Launch Page")
	public void teacher_verifies_the_page_is_in_launch_tab_and_room_name_is_displayed_on_the_centre_of_page() {
	   launchPage.verifyLaunchPage();
	}

}
