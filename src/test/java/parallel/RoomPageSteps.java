package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.Factory.DriverFactory;
import com.pages.RoomPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RoomPageSteps {
	
	private RoomPage roomPage;
	private WebDriver driver;
	private SoftAssert softAssert;

	public RoomPageSteps()
	{
		driver = DriverFactory.getDriver();
		roomPage = new RoomPage(driver);
		softAssert = new SoftAssert();
	}
	
	@When("Teacher clicks on Rooms Tab")
	public void teacher_clicks_on_rooms_tab() {
		roomPage.clickRooms(); 		
	}

	@Then("Teacher views the {string} Page")
	public void teacher_views_the_rooms_page(String title) {
		softAssert.assertEquals(title, roomPage.getRoomTitle());	
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
		Assert.assertTrue("Room Name not found", roomPage.verifyRoomName());
	}

	@When("Teacher clicks on the Room Name and confirms the Popup")
	public void teacher_clicks_on_the_room_name_and_confirms_the_popup() {
	}

	@Then("Teacher verifies the page is in Launch Tab and Room Name is displayed on the centre of page")
	public void teacher_verifies_the_page_is_in_launch_tab_and_room_name_is_displayed_on_the_centre_of_page() {
	}

}
