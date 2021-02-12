package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.Factory.DriverFactory;
import com.pages.LaunchPage;
import com.util.ElementUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

	@Then("Teacher verifies the control is in the {string} Page")
	public void teacher_verifies_control_is_in_the_page(String page) {
	   ElementUtil ele = new ElementUtil(driver);
	   softAssert.assertTrue(ele.verifyControlOnTab(page));
	}
	
	@When("Teacher clicks on Launch Tab")
	public void teacher_clicks_on_launch_tab() {
	    launchPage.clickOnLaunchTab();
	}

	@When("Teacher clicks on Quiz")
	public void teacher_clicks_on_quiz() {
	    launchPage.clickOnQuizBtn();
	}

	@When("Teacher selects the Quiz from the list and click on Next")
	public void teacher_selects_the_quiz_from_the_list_and_click_on_next() {
	    launchPage.selectQuizFromList();
	    launchPage.clickOnNextBtn();
	}

	@When("Teacher enters the Delivery Method as {string} and Settings")
	public void teacher_enters_the_delivery_method_and_settings(String method) {
	    launchPage.selectDeliverySettings(method);
	}
	
	@When("Teacher click on Start Button to Launch a quiz")
	public void teacher_click_on_start_button_to_launch_a_quiz()
	{
	    launchPage.clickOnStartBtn();
	}

}
