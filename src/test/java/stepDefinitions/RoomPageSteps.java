package stepDefinitions;

import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
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
		AssertJUnit.assertEquals(title, roomPage.getRoomTitle());	
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
	public void teacher_verifies_room_added_message_and_room_name_in_the_page() throws InterruptedException {
		AssertJUnit.assertTrue("Room Name not found", roomPage.verifyRoomName());
	}

	@When("Teacher clicks on the Room Name and confirms the Popup")
	public void teacher_clicks_on_the_room_name_and_confirms_the_popup() {
		roomPage.clickOnRoom();
		roomPage.confirmPopUp();		
	}
	
	@Then("Teacher verifies Room Name is displayed on the centre of page")
	public void teacher_verifies_room_name_is_displayed_on_the_centre_of_page()
	{
		AssertJUnit.assertTrue(roomPage.verifyHeaderRoomName());
	}
}
