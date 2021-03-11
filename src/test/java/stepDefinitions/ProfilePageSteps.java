package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.factory.DriverFactory;
import com.pages.AccountCreationPage;
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
	
	@Then("Teacher verifies the {string} popup on the page")
	public void teacher_verifies_popup_on_the_page(String text)
	{
		Assert.assertTrue(profilePage.verifyPopup(text));
	}
	
	@When("Teacher clicks on Yes in the Popup")
	public void teacher_clicks_on_yes_in_the_popup()
	{
		profilePage.clickOnYesInPopUp();
	}
	
	@When("Teacher clicks on Profile Button")
	public void teacher_clicks_on_profile_button() {
		profilePage.clickOnProfileBtn();
	}

	@When("Teacher clicks on Account Link on Profile")
	public void teacher_clicks_on_account_link_on_profile() 
	{
		profilePage.clickOnAccountLink();
	}

	@When("Teacher clicks on Upgrade PRO Button on the page")
	public void teacher_clicks_on_upgrade_pro_button_on_the_page() {
		profilePage.clickOnUpgradeProBtn();
	}
	
	@Then("Teacher views the default options for Seats and years as {int}")
	public void teacher_views_the_default_options_for_seats_and_years_as(int count)
	{
		Assert.assertTrue(profilePage.verifyDefaultOptions(count));
	}
	
	@When("Teacher selects seats, years and coupon code if available")
	public void teacher_selects_seats_years_and_coupon_code_if_available() throws InterruptedException {
		profilePage.enterNumberOfSeats();
		profilePage.enterNumberOfYears();
		profilePage.enterCouponCode();
	}

	@Then("Teacher validates the Total Amount with ${double} per seat")
	public void teacher_validates_the_total_amount_based_on_the_seats_and_years(double price)
	{
		profilePage.validateTotalAmount(price);
	}
	
	@When("Teacher clicks on Review and Pay button")
	public void teacher_clicks_on_review_and_pay_button() {
		profilePage.clickOnReviewAndPayBtn();
	}

	@Then("Teacher views the {string} page")
	public void teacher_views_the_page(String page) {
		Assert.assertTrue(page.equalsIgnoreCase(profilePage.getPaymentInfoHeader()));
	}

	@When("Teacher enters the card details - Card Name, Card Number, Expiry Date, CVC")
	public void teacher_enters_the_card_details_card_name_card_number_expiry_date_cvc() {
		profilePage.enterCardDetails();
	}

	@When("Teacher clicks on Purchase button")
	public void teacher_clicks_on_purchase_button() {
		profilePage.clickOnPurchaseBtn();
	}
	
	@Then("Teacher views {string} message on the page")
	public void teacher_views_message_on_the_page(String message) {
		Assert.assertEquals(message, profilePage.getPaymentCompleteHeaderText());
	}
	
	@Then("Teacher validates the details - name, email, license key, order number, order total")
	public void teacher_validates_the_details_name_email_license_key_order_number_order_total() {
		profilePage.validatePaymentDetails();
	}
	
	@Then("Teacher views the Account is changed to Pro Account")
	public void teacher_views_the_account_is_changed_to_pro_account() {
		Assert.assertTrue(profilePage.validateProAccount());
	}
	
	@When("Teacher clicks on {string} button")
	public void teacher_clicks_on_delete_account_button(String btn) throws InterruptedException {
		profilePage.clickOnButton(btn);
	}
	
	@Then("Teacher views the {string} popup Window")
	public void teacher_views_the_popup_window(String text) {
		
	}
	
	@When("Teacher enters the password in the field")
	public void teacher_enters_the_password_in_the_field()
	{
		profilePage.enterPwdToDeleteAcct();
	}
}
