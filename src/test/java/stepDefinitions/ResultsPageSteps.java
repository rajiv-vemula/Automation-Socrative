package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.pages.ResultsPage;
import com.util.ElementUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResultsPageSteps {

	private ResultsPage resultsPage;
	private WebDriver driver;
	
	public ResultsPageSteps()
	{
		driver = DriverFactory.getDriver();
		resultsPage = new ResultsPage(driver);	
	}
	
	@Then("Teacher verifies the activity is {string} from Results Page")
	public void teacher_verifies_the_activity_is_from_results_page(String type)
	{
		Assert.assertTrue(resultsPage.verifyActivity(type));
	}
	
	@Then("Teacher views the QuizName, Show Names, Responses and Results Toggle in the page")
	public void teacher_views_the_quiz_name_show_names_responses_and_results_toggle_in_the_page() {
		Assert.assertTrue(resultsPage.verifyQuizName());
		resultsPage.verifyToggles("Active Activity");
	}
	
	@When("Teacher clicks on Finish Button on results Page")
	public void teacher_clicks_on_finish_button_on_results() {
	    resultsPage.clickOnFinishBtn();
	}

	@Then("Teacher views the {string} Popup on the page")
	public void teacher_views_the_popup_on_the_page(String string) {
	    Assert.assertTrue(resultsPage.verifyFinishPopup(string));
	}
	
	@When("Teacher clicks on {string} Button in the Popup")
	public void teacher_clicks_on_finish_button_in_the_popup(String popupBtn)
	{
		resultsPage.clickOnButtonInPopUp(popupBtn);
	}
	
	@Then("Teacher views the Toggles, Share and Export Button")
	public void teacher_views_the_toggles_share_and_export_button() {
		Assert.assertTrue(resultsPage.verifyShareBtn());
		Assert.assertTrue(resultsPage.verifyExportBtn());
		resultsPage.verifyToggles("After Activity");
	}
	
	@When("Teacher clicks on Results Tab")
	public void teacher_clicks_on_results_tab()
	{
		
	}
	
	@When("Teacher clicks on Launch Activity Button")
	public void teacher_clicks_on_launch_activity_button()
	{
		
	}
	
	@Then("Teacher verifies Space Race is launched with all the functionalities")
	public void teacher_verifies_space_race_is_launched_with_all_the_functionalities()
	{
		
	}
	
	@Then("Teacher clicks on OK to Confirm the Popup")
	public void teacher_clicks_on_ok_to_confirm_the_popup()
	{
		
	}

}
