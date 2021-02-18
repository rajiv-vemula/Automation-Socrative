package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.pages.ProfilePage;

import io.cucumber.java.en.*;

public class ProfilePageSteps {
	private ProfilePage profilePage;
	private WebDriver driver;
	
	public ProfilePageSteps()
	{
		driver = DriverFactory.getDriver();
		profilePage = new ProfilePage(driver);	
	}

	@When("Teacher clicks on Header username on top right corner")
	public void teacher_clicks_on_header_username_on_top_right_corner()
	{
		profilePage.clickOnHeaderUsername();
	}
	
	@When("Teacher clicks on Sign Out Button")
	public void teacher_clicks_on_sign_out_button()
	{
		profilePage.clickOnSignOutButton();
	}
	
	@Then("Teacher verifies the {string} popup to Signout of application")
	public void teacher_verifies_popup_to_signout_of_application(String text)
	{
		Assert.assertTrue(profilePage.verifyPopup(text));
	}
	
	@When("Teacher clicks on Yes in the Popup")
	public void teacher_clicks_on_yes_in_the_popup()
	{
		profilePage.clickOnYesInPopUp();
	}
	
}
