package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.Factory.DriverFactory;
import com.pages.LoginPage;
import com.util.CommonUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage;
	private WebDriver driver;
	
	public LoginPageSteps()
	{
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);	
	}
	
	@Given("Teacher navigates to Socrative Login Page")
	public void teacher_navigates_to_socrative_login_page() {
		driver.get(CommonUtils.getURL());
	}

	@When("Teacher enters Username and Password")
	public void teacher_enters_username_and_password(DataTable dataTable) throws InterruptedException {
		List<List<String>> loginList = dataTable.asLists(String.class);	
		
		loginPage.enterEmail(loginList.get(0).get(0));
		loginPage.enterPassword(loginList.get(0).get(1));
	}

	@Then("Teacher views the {string} and {string} Links")
	public void teacher_views_the_reset_password_and_create_account_links(String ResetPwd, String CreateAcct)
	{
		Assert.assertTrue(loginPage.verifyLinks(ResetPwd,CreateAcct));
	}
	
	@When("Teacher clicks on Sign In Button")
	public void teacher_clicks_on_sign_in_button() throws InterruptedException {
		loginPage.clickOnSignIn();
	}

	@Then("Teacher views the Socrative Home Page")
	public void teacher_views_the_socrative_home_page() {
		Assert.assertTrue("Socrative Home Page is not visible",loginPage.verifyLogin());
	}

	
}
