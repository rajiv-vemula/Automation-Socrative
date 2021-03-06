package showbieStepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.Factory.DriverFactory;
import com.showbiePages.ShowbiePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ShowbiePageSteps {
	private ShowbiePage showbiePage;
	private WebDriver driver;
	
	public ShowbiePageSteps()
	{
		driver = DriverFactory.getDriver();
		showbiePage = new ShowbiePage(driver);
	}

	@Given("Teacher navigates to Showbie Login Page")
	public void teacher_navigates_to_showbie_login_page() {
	    driver.get("https://myqa.showbie.com/signin");
	}

	@Then("Teacher views the default Showbie {string} Page")
	public void teacher_views_the_default_showbie_login_page(String page) {
	    Assert.assertEquals(page, showbiePage.verifyShowbieLoginPage());
	}

	@When("Teacher enters Showbie username and Password")
	public void teacher_enters_showbie_username_and_password(DataTable data) {
		List<List<String>> loginList = data.asLists(String.class);	
		
		showbiePage.enterEmail(loginList.get(0).get(0));
		showbiePage.enterPassword(loginList.get(0).get(1));
	}

	@When("Teacher clicks on Sign In Button in Showbie")
	public void teacher_clicks_on_sign_in_button_in_showbie() {
	    showbiePage.clickOnSignInBtn();
	}

	@Then("Teacher views the Showbie Home Page with {string} text")
	public void teacher_views_the_showbie_home_page(String text) {
		Assert.assertEquals(text,showbiePage.verifyShowbieHomePageText());
	}

	@When("Teacher clicks on Wrench Button")
	public void teacher_clicks_on_wrench_button() {
	    showbiePage.clickOnWrenchBtn();
	}

	@When("Teacher clicks on New Class Button")
	public void teacher_clicks_on_new_class_button() {
		showbiePage.clickOnNewClassBtn();
	}

	@Then("Teacher views {string} Window with default options")
	public void teacher_views_window_with_default_options(String window) {
		Assert.assertTrue(showbiePage.verifyNewClassWindow(window));
		Assert.assertTrue(showbiePage.verifyNewClassDefaultOptions());
	}

	@When("Teacher enters the Class Name in New Class field")
	public void teacher_enters_the_class_name_in_new_class_field() {
		showbiePage.enterClassName();
	}

	@When("Teacher clicks on Save button")
	public void teacher_clicks_on_save_button() {
		showbiePage.clickOnSaveBtn();
	}

	@Then("Teacher views the Class is added with the name")
	public void teacher_views_the_class_is_added_with_the_name() {
		Assert.assertTrue(showbiePage.verifyClassInTheList());
	}

	@When("Teacher clicks on New Assignment button")
	public void teacher_clicks_on_new_assignment_button() {
	    showbiePage.clickOnNewAssignmentBtn();
	}

	@Then("Teacher New Assignment Window is opened with default options")
	public void teacher_new_assignment_window_is_opened_with_default_options() {
		Assert.assertTrue(showbiePage.verifyNewAssignmentWindow());
	}

	@When("Teacher enters the Assignment name in the Title")
	public void teacher_enters_the_assignment_name_in_the_title() {
	    showbiePage.enterAssignmentName();
	}

	@When("Teacher selects the DueDate, Student Access and Schedule")
	public void teacher_selects_the_due_date_student_access_and_schedule() {
		showbiePage.enterDueDateAndTime();
		showbiePage.enterStudentAccess();
	}

	@Then("Techer views {string} guide tip in the page")
	public void teacher_views_guide_tip_in_the_page(String text) throws InterruptedException
	{
		Assert.assertEquals(text, showbiePage.getToolTipText());
	}
	
	@Then("Teacher views the Assignment with selected settings is displayed in the page under Assigned")
	public void teacher_views_the_assignment_with_selected_settings_is_displayed_in_the_page_under_assigned() {
	   Assert.assertTrue(showbiePage.verifyAssignmentDetailsUnderAssigned());
	}

	@When("Teacher clicks on the Assignment Name")
	public void teacher_clicks_on_the_assignment_name() {
		showbiePage.selectAssignment();
	}

	@Then("Teacher views the Assignment Name and {string} folder")
	public void teacher_views_the_assignment_name_and_folder(String folder) {
	    Assert.assertTrue(showbiePage.verifyAssignmentNameOnHeader());
	    Assert.assertTrue(showbiePage.verifyFolder(folder));
	}

	@When("Teacher clicks on Shared Items folder")
	public void teacher_clicks_on_shared_items_folder() {
		showbiePage.clickOnSharedItemsFolder();
	}

	@Then("Teacher verifies {string} page with {string} textarea")
	public void teacher_verifies_page_with_textarea(String page, String comment) {
		Assert.assertTrue(showbiePage.verifyPage(page));
		Assert.assertTrue(showbiePage.verifyTextArea(comment));
	}

	@When("Teacher enters the post in the comment textarea")
	public void teacher_enters_the_post_in_the_comment_textarea() {
	    showbiePage.enterComment();
	}

	@When("Teacher clicks on Post button")
	public void teacher_clicks_on_post_button() {
		showbiePage.clickOnPostBtn();
	}

	@Then("Teacher validates the post is displayed in the post container")
	public void teacher_validates_the_post_is_displayed_in_the_post_container() {
	    Assert.assertTrue(showbiePage.validatePostInThePostContainer());
	}

	@When("Teacher clicks on + button")
	public void teacher_clicks_on_button() {
		showbiePage.clickonAddPostBtn();
	}

	@When("Teacher clicks on New Document button")
	public void teacher_clicks_on_new_document_button() {
	}

	@Then("Teacher verifies New Document Window is opened with default settings")
	public void teacher_verifies_new_document_window_is_opened_with_default_settings() {
	}

	@When("Teacher enters the Document Name, Orientation and Style")
	public void teacher_enters_the_document_name_orientation_and_style() {
	    
	}

	@When("Teacher clicks on Create button")
	public void teacher_clicks_on_create_button() {
	    
	}

	@Then("Teacher validates the document is posted in the Post container")
	public void teacher_validates_the_document_is_posted_in_the_post_container() {
	    
	}
}
