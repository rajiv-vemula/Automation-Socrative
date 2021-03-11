package com.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.util.ConfigReader;
import com.util.ElementUtil;
import pojo.Teacher;

public class AccountCreationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Teacher teacher;
	
	By registerPageHeader = By.id("register-steps-header");
	// Profile Link
	By profileLink = By.xpath("//ul[@class='profile-nav']/li[contains(text(),'PROFILE')]");
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("email");
	By confirmEmail = By.id("email2");
	By password = By.id("password");
	By confirmPassword = By.id("password2");
	By changePasswordLink = By.xpath("//a[contains(text(),'Change Password')]");
	By createAcctNxtBtn = By.xpath("//button[text()='NEXT']");
	By createAcctCancelBtn = By.xpath("//button[text()='CANCEL']");
	
	// Demographics Link
	By demographicsLink = By.xpath("//li[contains(text(),'DEMOGRAPHICS')]");
	By country = By.xpath("//div[.//p[text()='Country']]/div/div/input");
	By language = By.xpath("//div[.//p[text()='Language']]/div/div/input");
	By organizationType = By.xpath("//div[.//p[text()='Organization Type']]/div/div/input");
	By organizationName = By.id("orgName");
	By orgRole = By.xpath("//div[.//p[text()='Role']]/div/div/input");
	By termsAndPolicy = By.id("terms");
	
	// Account Type
	By freeAcct = By.xpath("//div[text()='Socrative FREE']/parent::div");
	By proAcct = By.xpath("//*[@class='pro-account-type-icon']/parent::div");
	By finishBtn = By.id("register-finish-button");
	
	// Accounts Link
	By accountLink = By.xpath("//li[contains(text(),'ACCOUNT')]");
	By purchaseLicenseBtn = By.id("renewLicenseButton");
	By deleteAccountBtn = By.id("delete-account-button");
	By socrativeProIcon = By.cssSelector(".default-pro-icon");
	By licenseKeyTxt = By.xpath("//span[contains(text(),'License Key')]//following-sibling::span[1]");
	By expiryDateTxt = By.xpath("//span[contains(text(),'Expiration Date')]//following-sibling::span[1]");
	
	// Popup
	By popUpTitle = By.className("popup-title");
	By popUpMessage = By.id("pop-up-message");
	By popUpOkBtn = By.xpath("//button[text()='OK']");
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
		teacher = new Teacher();
	}

	public String verifyPageHeader() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(registerPageHeader));
		return driver.findElement(registerPageHeader).getText();
	}
	
	public void enterSignUpDetails(String fname, String lname, String emailID, String pwd) {
		teacher.setFirstName(prop.getProperty(fname));
		teacher.setLastName(prop.getProperty(lname));
		teacher.setEmail(prop.getProperty(emailID));
		teacher.setPassword(prop.getProperty(pwd));
		
		driver.findElement(firstName).sendKeys(teacher.getFirstName());
		driver.findElement(lastName).sendKeys(teacher.getLastName());
		driver.findElement(email).sendKeys(teacher.getEmail());
		driver.findElement(confirmEmail).sendKeys(teacher.getEmail());
		driver.findElement(password).sendKeys(teacher.getPassword());
		driver.findElement(confirmPassword).sendKeys(teacher.getPassword());
	}

	public void clickOnNextBtnOnSignUpPage() {
		wait.until(ExpectedConditions.elementToBeClickable(createAcctNxtBtn));
		driver.findElement(createAcctNxtBtn).click();
	}

	public String getPageHeader(String page) {
		By registerFormHeader = ElementUtil.getPath(page);
		wait.until(ExpectedConditions.visibilityOfElementLocated(registerFormHeader));
		return driver.findElement(registerFormHeader).getText();
	}

	public void enterDemographics() {
		teacher.setCountry(prop.getProperty("Country"));
		teacher.setOrgType(prop.getProperty("OrganizationType"));
		teacher.setOrgName(prop.getProperty("OrganizationName"));
		teacher.setOrgRole(prop.getProperty("OrgRole"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(country));
		driver.findElement(country).click();
		driver.findElement(dropDownElement(teacher.getCountry())).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(organizationType));
		driver.findElement(organizationType).click();
		driver.findElement(dropDownElement(teacher.getOrgType())).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(organizationName));
		driver.findElement(organizationName).sendKeys(teacher.getOrgName());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(orgRole));
		driver.findElement(orgRole).click();
		driver.findElement(dropDownElement(teacher.getOrgRole())).click();
	}

	public By dropDownElement(String input)	{
		return ElementUtil.getliElementFromList(input);
	}
	
	public void acceptTermsAndPolicy() {
		driver.findElement(termsAndPolicy).click();
	}

	public void clickOnFreeAcct() {
		wait.until(ExpectedConditions.elementToBeClickable(freeAcct));
		driver.findElement(freeAcct).click();
	}

	public void clickOnFinishBtn() {
		driver.findElement(finishBtn).click();
	}

	public String getPopUpTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(popUpTitle));
		return driver.findElement(popUpTitle).getText();
	}

	public void clickOnOKBtnInPopUp() {
		wait.until(ExpectedConditions.elementToBeClickable(popUpOkBtn));
		driver.findElement(popUpOkBtn).click();
	}
	
	

}
