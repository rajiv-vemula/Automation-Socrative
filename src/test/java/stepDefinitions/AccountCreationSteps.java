package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.factory.DriverFactory;
import com.pages.AccountCreationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreationSteps {

	private AccountCreationPage acctPage;
	private WebDriver driver;
	
	public AccountCreationSteps()
	{
		driver = DriverFactory.getDriver();	
		acctPage = new AccountCreationPage(driver);
	}	

	@Then("Teacher views {string} page")
	public void teacher_views_page(String page)
	{
		Assert.assertTrue(page.equalsIgnoreCase(acctPage.verifyPageHeader()));
	}
	
	@When("Teacher enters the signUp details - {string}, {string}, {string} and {string}")
	public void teacher_enters_the_sign_up_details_firstname_lastname_email_password(String firstName, String lastName, String email, String password) {
		acctPage.enterSignUpDetails(firstName,lastName,email,password);
	}

	@When("Teacher clicks on Next button on Signup Page")
	public void teacher_clicks_on_next_button_on_signup_page() {
		acctPage.clickOnNextBtnOnSignUpPage();
	}

	@Then("Teacher views the {string} Page on SignUp")
	public void teacher_views_the_page_on_signup(String page) throws InterruptedException {
		Assert.assertEquals(page, acctPage.getPageHeader(page));
	}

	@When("Teacher enters the Demographics and accepts the Terms and Pvt Policy")
	public void teacher_enters_the_demographics_and_accepts_the_terms_and_pvt_policy() {
		acctPage.enterDemographics();
		acctPage.acceptTermsAndPolicy();
	}

	@When("Teacher clicks on Socrative Free Account")
	public void teacher_clicks_on_socrative_free_account() {
		acctPage.clickOnFreeAcct();
	}

	@When("Teacher clicks on Finish Button for Registration")
	public void teacher_clicks_on_finish_button_for_registration() {
		acctPage.clickOnFinishBtn();
	}

	@Then("Teacher views the {string} popup title")
	public void teacher_views_the_popup_title(String title) {
		Assert.assertEquals(title, acctPage.getPopUpTitle());
	}

	@When("Teacher clicks on OK button in the Popup")
	public void teacher_clicks_on_ok_button_in_the_popup() {
		acctPage.clickOnOKBtnInPopUp();
	}
}
