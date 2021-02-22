package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.pages.ReportsPage;
import com.util.ElementUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportsPageSteps {

	private ReportsPage reportsPage;
	private WebDriver driver;
	
	public ReportsPageSteps()
	{
		driver = DriverFactory.getDriver();
		reportsPage = new ReportsPage(driver);
	}
	
	@When("Teacher clicks on the {int}st question from Results Grid")
	public void teacher_clicks_on_the_question_from_results_grid(int questionNumber) {
	    reportsPage.clickOnQuestion(questionNumber);
	}

	@Then("Teacher views the question with buttons for respective question types")
	public void teacher_views_the_question_with_buttons_for_respective_question_type() {
	    // Show Results Button for MC & TF
		// Show Names and Hide Answers button for SA
	}

	@Then("Teacher navigates between questions")
	public void teacher_navigates_between_questions() {
	    reportsPage.navigateBetweenQuestions();
	}
	
	@When("Teacher clicks on {string} button on Reports Page")
	public void teacher_clicks_on_button_on_reports_page(String button)
	{
		reportsPage.clickOnButton(button);
	}
	
	@Then("Teacher verifies the date and time of the Report in the page")
	public void teacher_verifies_the_date_and_time_of_the_report_in_the_page()
	{
		ElementUtil ele = new ElementUtil(driver);
		Assert.assertTrue(ele.verifyDateAndTime());
	}
}
