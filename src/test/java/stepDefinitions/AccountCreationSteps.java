package stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
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
	
//	@When("Teacher enters the signUp details")
//    public void teacher_enters_the_signup_details(){
//        
//    }
//
//    @When("Teacher enters the Demographics and accepts the Terms & Conditions")
//    public void teacher_enters_the_demographics_and_accepts_the_terms_conditions() {
//        
//    }
//
//    @When("Teacher clicks on Socrative Free Account")
//    public void teacher_clicks_on_socrative_free_account() {
//        
//    }
//
//    @When("Teacher clicks on OK button")
//    public void teacher_clicks_on_ok_button()  {
//        
//    }
//
//    @When("Teacher clicks on Header username on top right corner")
//    public void teacher_clicks_on_header_username_on_top_right_corner() {
//        
//    }
//
//    @When("Teacher enters the card details and clicks on Purchase")
//    public void teacher_enters_the_card_details_and_clicks_on_purchase() {
//        
//    }
//
//    @Then("Teacher views the Demographics Page")
//    public void teacher_views_the_demographics_page() {
//        
//    }
//
//    @Then("Teacher views the Account Type Page to select the type")
//    public void teacher_views_the_account_type_page_to_select_the_type(){
//        
//    }
//
//    @Then("Teacher views the {string} popup title")
//    public void teacher_views_the_popup_title(String title) {
//        
//    }
//
//    @Then("Teacher views the {string} page")
//    public void teacher_views_the_page(String title) {
//        
//    }
//
//    @Then("Teacher views the Account is changed to Pro Account")
//    public void teacher_views_the_account_is_changed_to_pro_account() {
//        
//    }
//
//    @When("Teacher clicks on Next")
//    public void teacher_clicks_on_next() {
//        
//    }
//
//    @When("Teacher clicks on Finish Button for Registration")
//    public void teacher_clicks_on_finish_button_for_registration() {
//        
//    }
//
//    @When("Teacher clicks on Profile Button")
//    public void teacher_clicks_on_profile_button() {
//        
//    }
//
//    @When("Teacher clicks on Account Link and Upgrade PRO Button")
//    public void teacher_clicks_on_account_link_and_upgrade_pro_button() {
//        
//    }
//
//    @When("Teacher selects seats, years and enters coupon code and apply")
//    public void teacher_selects_seats_years_and_enters_coupon_code_and_apply() {
//        
//    }
//
//    @When("Teacher clicks on Review and Pay button")
//    public void teacher_clicks_on_review_and_pay_button() {
//        
//    }
}
