package stepDefinitions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.pages.StudentPage;
import com.util.CommonUtils;

import io.cucumber.java.en.When;

public class StudentPageSteps {

	private StudentPage studentPage;
	private WebDriver driver;
	private DriverFactory driverFactory;
	
	public StudentPageSteps()
	{
		driverFactory = new DriverFactory();
		driverFactory.init_driver("firefox");
		driver = DriverFactory.getDriver();
		studentPage = new StudentPage(driver);
	}
	
	@When("Student navigates to Socrative Login Page")
	public void student_navigates_to_socrative_login_page()
	{
		driver.get(CommonUtils.getURL("Student"));
		driver.manage().window().setPosition(new Point(800, 400));
		//driver.quit();
	}
}
