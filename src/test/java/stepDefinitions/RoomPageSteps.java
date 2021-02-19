package stepDefinitions;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Factory.DriverFactory;
import com.pages.RoomPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RoomPageSteps {
	
	private RoomPage roomPage;
	private WebDriver driver;

	public RoomPageSteps()
	{
		driver = DriverFactory.getDriver();
		roomPage = new RoomPage(driver);
	}
	
	@When("Teacher clicks on Rooms Tab")
	public void teacher_clicks_on_rooms_tab() {
		roomPage.clickRooms(); 		
	}

	@Then("Teacher views {string} Page")
	public void teacher_views_rooms_page(String title) {
		Assert.assertEquals(title, roomPage.getRoomTitle());	
	}

	@When("Teacher clicks on Add Room")
	public void teacher_clicks_on_add_room() {
		roomPage.clickAddRoom();
	}

	@When("Teacher enters the Room Name and clicks on Add")
	public void teacher_enters_the_room_name_and_clicks_on_add() {
		roomPage.enterRoomName();
		roomPage.clickOnAddBtn();
	}

	@Then("Teacher verifies Room Added Message and Room Name in the page")
	public void teacher_verifies_room_added_message_and_room_name_in_the_page() {
		Assert.assertTrue(roomPage.verifyRoomName());
	}

	@When("Teacher clicks on the Room Name and confirms the Popup")
	public void teacher_clicks_on_the_room_name_and_confirms_the_popup() {
		roomPage.clickOnRoom();
		roomPage.confirmPopUp();		
	}
	
	@Then("Teacher verifies Room Name is displayed on the centre of page")
	public void teacher_verifies_room_name_is_displayed_on_the_centre_of_page()
	{
		Assert.assertTrue(roomPage.verifyHeaderRoomName());
	}
	
	@When("Teacher clicks on Roster button to add students")
	public void teacher_clicks_on_roster_button_to_add_students()
	{
		roomPage.clickOnRosterButton();
	}
	
	@When("Teacher clicks on {string} method to enter the students")
	public void teacher_clicks_on_method_to_enter_the_students(String method)
	{
		roomPage.clickOnMethod(method);
	}
	
	@Then("Teacher views {string} title window to select number of students")
	public void teacher_views_title_window_to_select_number_of_students(String title)
	{
		Assert.assertEquals(title, roomPage.verifyTitleWindow());
	}
	
	@When("Teacher enters the number of students to add")
	public void teacher_enters_the_number_of_students_to_add()
	{
		roomPage.enterStudentCount();
	}
	
	@When("Teacher clicks on Create Form button")
	public void teacher_clicks_on_create_form()
	{
		roomPage.clickOnCreateForm();
	}
	
	@Then("Teacher views the modal with default options")
	public void teacher_views_the_modal_with_default_options()
	{
		Assert.assertTrue(roomPage.verifyAddStudentModal());
	}
	
	@When("Teacher enters the student details - firstname, lastname, ID, email")
	public void teacher_enters_the_student_details_firstname_lastname_id_email()
	{
		roomPage.enterStudenDetails();
	}
	
	@When("Teacher clicks on {string} button in the form")
	public void teacher_clicks_on_button_in_the_form(String button)
	{
		roomPage.clickOnButtonInForm(button);
	}
	
	@Then("Teacher validates the student details in the Roster")
	public void teacher_validates_the_student_details_in_the_roster()
	{
		Assert.assertTrue(roomPage.validateStudentDetailsInRoster());
	}
	
}
