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

	@When("Teacher clicks on the first question")
	public void teacher_clicks_on_the_first_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Teacher views the question with Show Results button")
	public void teacher_views_the_question_with_show_results_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Teacher views the navigate between question button")
	public void teacher_views_the_navigate_between_question_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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

}
