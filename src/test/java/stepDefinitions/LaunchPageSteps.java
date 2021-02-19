package stepDefinitions;

import org.junit.Assert;
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
	
	@When("Teacher clicks on Short Answer from Quick Question Section")
	public void teacher_clicks_on_short_answer_from_quick_question_section()
	{
		launchPage.clickOnSABtn();
	}
	
	@Then("Teacher verifies SA View with default options")
	public void teacher_verifies_sa_view_with_default_options()
	{
		Assert.assertTrue(launchPage.verifySAView());
	}
	
	@When("Teacher enters the question under Optional Question Section")
	public void teacher_enters_the_question_under_optional_question_section()
	{
		launchPage.enterOptionalQuestion();
	}
	
	@When("Teacher selects the toggles for {string} and {string}")
	public void teacher_selects_the_toggles_for_and(String toggle1,String toggle2)
	{
		launchPage.selectToggles(toggle1,toggle2);
	}
	
	@When("Teacher clicks on Start Button in the SA Box")
	public void teacher_clicks_on_start_button_in_the_sa_box()
	{
		launchPage.clickOnSAStartBtn();
	}
	
	@Then("Teacher views the {string} text with current date and time")
	public void teacher_views_the_text_with_current_date_and_time(String text)
	{
		Assert.assertTrue(launchPage.verifyQuickQuestionText(text));
		ElementUtil ele = new ElementUtil(driver);
		Assert.assertTrue(ele.verifyDateAndTime());	
	}
	
	@Then("Teacher views the {string}, {string}, {string} Buttons")
	public void teacher_views_the_buttons(String button1, String button2, String button3)
	{
		Assert.assertTrue(launchPage.verifyButtons(button1,button2,button3));
	}
	
	@When("Teacher clicks on Space Race")
	public void teacher_clicks_on_space_race()
	{
		launchPage.clickOnSpaceRace();
	}
	
	@When("Teacher choose the Space Race Settings with teams")
	public void teacher_choose_the_space_race_settings_with_teams()
	{
		launchPage.selectSpaceRaceSettings();
	}

}
