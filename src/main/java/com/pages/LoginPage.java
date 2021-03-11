package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
    private WebDriverWait wait;
	
	// 1. By Locators
    private By emaildId = By.name("email");
    private By password = By.name("password");
	private By signInButton = By.id("teacherLoginButton");
	private By headerName = By.cssSelector("#header-room-name");
	private By userName = By.cssSelector("#header-user-name span");
	private By teacherLoginMessage = By.xpath("//h1[contains(text(),'Teacher Login')]");
	private By teacherLoginForm = By.id("teacherLoginForm");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By signUpemail = By.id("email");
	private By confirmEmail = By.id("email2");
	private By signUpPwd = By.id("password");
	private By confirmPwd = By.id("password2");
	private By cancelBtn = By.xpath("//button[contains(text(),'CANCEL')]");
	private By nextBtn = By.xpath("//button[contains(text(),'NEXT')]");
	private By countryList = By.cssSelector("input[value='Select Your Country']");
	private By organizationType = By.cssSelector("input[value='Select Your Organization Type']");
	private By organizationName = By.id("orgName");
	private By role = By.cssSelector("input[value='Select Your Role']");
	private By termsCheckBox = By.id("terms");
	private By freeAcct = By.cssSelector(".free-account-type-icon");
	private By finishBtn = By.id("register-finish-button");
	private By popUpTitle = By.cssSelector(".popup-title");
	private By popUpOKBtn = By.xpath("//button[contains(text(),'OK')]");
	
	// Socrative PRO
	private By socrativeProAcct = By.cssSelector(".pro-account-type-icon");
	private By enterLicenseKeyLink = By.xpath("//span[contains(text(),'Enter License Key')]");
	private By licenseKey = By.id("license-key-id");
	private By activateBtn = By.xpath("//button[contains(text(),'ACTIVATE')]");
	
	private By seats = By.id("licenseSeats");
	private By years = By.cssSelector("div.custom-select-container > input");
	private By couponName = By.id("couponName");
	private By applyCouponBtn = By.id("applyCouponButton");
	private By applyLicenseCheckBox = By.id("applyNow");
	private By reviewAndPayBtn = By.id("reviewAndPayButton");
	private By nameOnCard = By.id("nameOnCard");
	private By cardNumber = By.id("cardNumber");
	private By expiryDate = By.cssSelector("input[value='Month']");
	private By year = By.cssSelector("input[value='Year']");
	private By cvc = By.id("cvc");
	private By purchaseBtn = By.id("licensePurchaseButton");
	
	
	// 2.Contructor of the Page
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	//3. Page Actions: Features of the page the form of methods
	
	public boolean verifyLinks(String resetPwd, String createAcct)
	{
		return driver.findElement(By.linkText(resetPwd)).isDisplayed() && driver.findElement(By.linkText(createAcct)).isDisplayed();
	}
	
	public void enterEmail(String email)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(emaildId));
		driver.findElement(emaildId).sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnSignIn()
	{
		driver.findElement(signInButton).click();
	}
	
	public boolean verifyLogin()
	{	
		wait.until(ExpectedConditions.visibilityOfElementLocated(headerName));
		String name = driver.findElement(userName).getText();
		return driver.findElement(headerName).isDisplayed() && name.equals("Rajiv");
	}

	public boolean verifyLoginPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(teacherLoginMessage));	
		return driver.findElement(teacherLoginMessage).isDisplayed() && driver.findElement(teacherLoginForm).isDisplayed();
	}

	public void clickOnLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}

}
