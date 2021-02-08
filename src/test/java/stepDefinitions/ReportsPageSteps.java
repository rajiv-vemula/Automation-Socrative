package stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.pages.ReportsPage;
import com.pages.ResultsPage;

public class ReportsPageSteps {

	private ReportsPage reportsPage;
	private WebDriver driver;
	
	public ReportsPageSteps()
	{
		driver = DriverFactory.getDriver();
		reportsPage = new ReportsPage(driver);
	}
}
