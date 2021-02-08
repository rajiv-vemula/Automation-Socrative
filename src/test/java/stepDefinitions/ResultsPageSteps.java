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
	
	@Then("Teacher launches a quiz and control moves to {string} Tab")
	public void teacher_launches_a_quiz_and_control_moves_to_tab(String page) {
		ElementUtil ele = new ElementUtil(driver);
	    Assert.assertTrue(ele.verifyControlOnTab(page));
	}
	
	@Then("Teacher verifies activity is running from Results Page")
	public void teacher_verifies_activity_is_running_from_results_page()
	{
		Assert.assertTrue(resultsPage.verifyActiveActivity());
	}
	
	@Then("Teacher views the QuizName, Show Names, Responses and Results Toggle in the page")
	public void teacher_views_the_quiz_name_show_names_responses_and_results_toggle_in_the_page() {
		Assert.assertTrue(resultsPage.verifyLaunchQuiz());
		resultsPage.verifyToggles();
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

	@When("Teacher clicks on Finish")
	public void teacher_clicks_on_finish() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Teacher views the {string} Popup on the page")
	public void teacher_views_the_popup_on_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Teacher views the control is moved to Reports Tab")
	public void teacher_views_the_control_is_moved_to_reports_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Teacher views the Toggles, Share and Export Button")
	public void teacher_views_the_toggles_share_and_export_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
