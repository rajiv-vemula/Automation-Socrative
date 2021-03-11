package stepDefinitions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.StudentPage;
import com.util.CommonUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentPageSteps {

	private StudentPage studentPage;
	private WebDriver driver;
	
	public StudentPageSteps() {
		CommonUtils.getStudentDriver();
		driver = DriverFactory.getDriver();
		studentPage = new StudentPage(driver);
	}
	
	@When("Student navigates to Socrative Login Page")
	public void student_navigates_to_socrative_login_page() {
		driver.get(CommonUtils.getURL("Student"));
		driver.manage().window().setPosition(new Point(800, 400));
	}
	
	@Then("Student views {string} Window in the page")
	public void student_views_window_in_the_page(String title) {
		Assert.assertEquals(title, studentPage.getTitleWindowName());
	}
	
	@When("Student enters the Room Name and click on Join")
	public void student_enters_the_room_name_and_click_on_join() {
		studentPage.enterRoomName();
		studentPage.clickOnJoinBtn();
	}
	
	@When("Student enters the Student ID and clicks on Submit")
	public void student_enters_the_student_id_and_clicks_on_submit() {
		studentPage.enterStudentID();
		studentPage.clickOnJoinBtn();
	}
	
	@Then("Student views the Room Name and Last Name in the page")
	public void student_views_the_room_name_and_last_name_in_the_page() {
		Assert.assertTrue(studentPage.verifyRoomName());
		Assert.assertTrue(studentPage.verifyFirstName());
	}
	
	@When("Student answers the first question in the quiz")
	public void student_answers_the_first_question_in_the_quiz() {
		studentPage.answerFirstQuestion();
	}
	
	@When("Student clicks on Submit Button")
	public void student_clicks_on_submit_button() {
		studentPage.clickOnSubmitBtn();
	}
	
	@When("Student clicks on header user name")
	public void student_clicks_on_header_user_name() {
		studentPage.clickOnHeaderUserName();
	}
	
	@When("Student clicks on {string} button")
	public void student_clicks_on_button(String button) {
		studentPage.clickOnButton(button);
	}
	
	@Then("Student verifies the {string} popup to Signout of application")
	public void student_verifies_the_popup_to_signout_of_application(String popup) {
		Assert.assertEquals(popup,studentPage.verifyPopup());
	}
	
	@When("Student clicks on Yes in the popup")
	public void student_clicks_on_yes_in_the_popup() {
		studentPage.clickOnYesBtn();
	}
	
	@Then("Student views the Feedback Container with Question, Correct Answer and Explanation")
	public void student_views_the_feedback_container_with_question_correct_answer_and_explanation() {
		Assert.assertTrue(studentPage.verifyFeedbackContainer());
	}
	
	@When("Student clicks on OK in the Feedback Box")
	public void student_clicks_on_ok_in_the_feedback_box() {
		studentPage.clickOnOkBtn();
	}
	
	@When("Student answers the second question in the quiz")
	public void student_answers_the_second_question_in_the_quiz() {
		studentPage.answerSecondQuestion();
	}
	
	@When("Student answers the third question in the quiz")
	public void student_answers_the_third_question_in_the_quiz() {
		studentPage.answerThirdQuestion();
	}
	
	@Then("Student views the Activity Completed text in the page")
	public void student_views_the_activity_completed_text_in_the_page() {
		Assert.assertTrue(studentPage.verifyWaitingText());
	}
	
	@Then("Student closes the browser")
	public void student_closes_the_browser()
	{
		driver.quit();
	}
}
