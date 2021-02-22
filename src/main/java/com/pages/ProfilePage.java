package com.pages;

import java.util.Properties;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.ConfigReader;

public class ProfilePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	
	By headerUserName = By.cssSelector("div[id='header-user-name'] span");
	By profileBtn = By.xpath("//li[contains(text(),'PROFILE')]");
	By helpTopicsBtn = By.xpath("//li[contains(text(),'HELP TOPICS')]");
	By contactSocrativeBtn = By.xpath("//li[contains(text(),'CONTACT SOCRATIVE')]");
	By signOutBtn = By.xpath("//li[contains(text(),'SIGN OUT')]");
	By version = By.cssSelector(".app-version");
	By saveBtn = By.id("profile-save-button");
	By popUpTitle = By.cssSelector(".popup-title");
	By yesBtn = By.xpath("//button[contains(text(),'Yes')]");
	
	// Profile Link
	By profileLink = By.xpath("//ul[@class='profile-nav']/li[contains(text(),'PROFILE')]");// By.cssSelector(".profile-nav > li:nth-of-type(1)");
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("email");
	By changePasswordLink = By.xpath("//a[contains(text(),'Change Password')]");
	
	// Demographics Link
	By demographicsLink = By.xpath("//li[contains(text(),'DEMOGRAPHICS')]");
	By country = By.xpath("//div[.//p[text()='Country']]/div/div/input");
	By language = By.xpath("//div[.//p[text()='Language']]/div/div/input");
	By organizationType = By.xpath("//div[.//p[text()='Organization Type']]/div/div/input");
	By organizationName = By.id("orgName");
	By role = By.xpath("//div[.//p[text()='Role']]/div/div/input");
	
	// Accounts Link
	By AccountLink = By.xpath("//li[contains(text(),'ACCOUNT')]");
	By purchaseLicenseBtn = By.id("renewLicenseButton");
	By deleteAccountBtn = By.id("delete-account-button");
	By socrativeProIcon = By.cssSelector(".default-pro-icon");
	By licenseKeyTxt = By.xpath("//span[contains(text(),'License Key')]//following-sibling::span[1]");
	By expiryDateTxt = By.xpath("//span[contains(text(),'Expiration Date')]//following-sibling::span[1]");
	
	// Student Count
	By studentCountNumber = By.cssSelector(".student-count-number");
	By studentIcon = By.cssSelector(".student-count-icon");
	By clearRoom = By.id("clear-room");
	By showStudentId = By.id("show-student-ids");
	By enableHandRaise = By.id("handraise");
	
	// Purchase License
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
	
	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}


	public void clickOnHeaderUsername() {
		wait.until(ExpectedConditions.elementToBeClickable(headerUserName));
		driver.findElement(headerUserName).click();
	}


	public void clickOnSignOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(signOutBtn));
		driver.findElement(signOutBtn).click();
	}


	public boolean verifyPopup(String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(popUpTitle));
		return driver.findElement(popUpTitle).getText().equalsIgnoreCase(text);
	}


	public void clickOnYesInPopUp() {
		driver.findElement(yesBtn).click();
	}


}
