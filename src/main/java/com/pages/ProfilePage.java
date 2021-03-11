package com.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.util.ConfigReader;
import com.util.ElementUtil;
import pojo.Teacher;

public class ProfilePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Teacher teacher;
	
	private By headerUserName = By.id("header-user-name");
	private By profileBtn = By.xpath("//li[contains(text(),'PROFILE')]");
	private By helpTopicsBtn = By.xpath("//li[contains(text(),'HELP TOPICS')]");
	private By contactSocrativeBtn = By.xpath("//li[contains(text(),'CONTACT SOCRATIVE')]");
	private By signOutBtn = By.xpath("//li[contains(text(),'SIGN OUT')]");
	private By version = By.cssSelector(".app-version");
	private By saveBtn = By.id("profile-save-button");
	private By popUpTitle = By.className("popup-title");
	private By yesBtn = By.xpath("//button[contains(text(),'Yes')]");
	
	// Profile, Demographics & Account
	private By demographicsLink = By.xpath("//li[contains(text(),'DEMOGRAPHICS')]");
	private By acctLink = By.xpath("//li[contains(text(),'ACCOUNT')]");
	private By upgradeProfileBtn = By.id("profileUpgradeButton");
	
	// Student Count
	private By studentCountNumber = By.cssSelector(".student-count-number");
	private By studentIcon = By.cssSelector(".student-count-icon");
	private By clearRoom = By.id("clear-room");
	private By showStudentId = By.id("show-student-ids");
	private By enableHandRaise = By.id("handraise");
	
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
	private By expiryYear = By.cssSelector("input[value='Year']");
	private By cvc = By.id("cvc");
	private By purchaseBtn = By.id("licensePurchaseButton");
	private By paymentInfoText = By.className("payment-information-header-text");
	private By deleteAcctBtn = By.id("delete-account-button");
	private By deleteAcctQuestion = By.className("delete-account-question");
	private By deleteAcctBtnInPopUp = By.xpath("//button[text()='Delete Account']");
	private By cancelBtnInPopUp = By.xpath("//button[text()='Cancel']");
	private By totalAmountToPay = By.className("license-information-total-amount");
	
	// Purchase Complete
	private By paymentCompleteHeader = By.className("payment-complete-header");
	private By licenseKeyTxt = By.xpath("//span[text()='License Key']/following-sibling::span");
	private By nameTxt = By.xpath("//span[text()='Name']/following-sibling::span");
	private By emailTxt = By.xpath("//span[text()='Email']/following-sibling::span");
	private By orderTotalTxt = By.xpath("//span[text()='Order Total']/following-sibling::span");
	private By orderNumberTxt = By.xpath("//span[text()='Order Number']/following-sibling::span");
	private By defaultProIcon = By.className("default-pro-icon");
	private By passwordInPopUp = By.className("password-input");
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
		teacher = new Teacher();
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

	public void clickOnProfileBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(profileBtn));
		driver.findElement(profileBtn).click();
	}

	public void clickOnAccountLink() {
		wait.until(ExpectedConditions.elementToBeClickable(acctLink));
		driver.findElement(acctLink).click();
	}

	public void clickOnUpgradeProBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(upgradeProfileBtn));
		driver.findElement(upgradeProfileBtn).click();
	}

	public boolean verifyDefaultOptions(int count) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(seats));
		return driver.findElement(seats).getAttribute("value").equals(String.valueOf(count)) 
				&& 
				driver.findElement(years).getAttribute("value").equals(String.valueOf(count));
	}
	
	public void enterNumberOfSeats() throws InterruptedException {
		teacher.setSeats(Integer.parseInt(prop.getProperty("NoOfSeats")));
		driver.findElement(seats).clear();
		Thread.sleep(500);
		driver.findElement(seats).sendKeys(String.valueOf(teacher.getSeats()));
	}

	public void enterNumberOfYears() {
		teacher.setYears(Integer.parseInt(prop.getProperty("Years")));
		driver.findElement(years).click();
		
		By yearsField = ElementUtil.getliElementFromList(String.valueOf(teacher.getYears())); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(yearsField));
		driver.findElement(yearsField).click();
	}

	public void enterCouponCode() {
		if(prop.getProperty("CouponCode").isEmpty())
			System.out.println("No Coupon Code used for the purchase");
		else {
			teacher.setCouponCode(prop.getProperty("CouponCode"));
			driver.findElement(couponName).sendKeys(teacher.getCouponCode());
			driver.findElement(applyCouponBtn).click();
		}
	}

	public void clickOnReviewAndPayBtn() {
		driver.findElement(reviewAndPayBtn).click();
	}

	public String getPaymentInfoHeader() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoText));
		return driver.findElement(paymentInfoText).getText();
	}

	public void enterCardDetails() {
		teacher.setCardName(prop.getProperty("CardName"));
		teacher.setCardNumber(prop.getProperty("CardNumber"));
		teacher.setExpiryMonth(Integer.parseInt(prop.getProperty("ExpiryMonth")));
		teacher.setExpiryYear(Integer.parseInt(prop.getProperty("ExpiryYear")));
		teacher.setCvc(Integer.parseInt(prop.getProperty("CVC")));
		
		driver.findElement(nameOnCard).sendKeys(teacher.getCardName());
		driver.findElement(cardNumber).sendKeys(teacher.getCardNumber());
		
		driver.findElement(expiryDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ElementUtil.getliElementFromList(String.valueOf(teacher.getExpiryMonth()))));
		driver.findElement(ElementUtil.getliElementFromList(String.valueOf(teacher.getExpiryMonth()))).click();
		
		driver.findElement(expiryYear).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ElementUtil.getliElementFromList(String.valueOf(teacher.getExpiryYear()))));
		driver.findElement(ElementUtil.getliElementFromList(String.valueOf(teacher.getExpiryYear()))).click();
		
		driver.findElement(cvc).sendKeys(String.valueOf(teacher.getCvc()));
	}

	public void clickOnPurchaseBtn() {
		driver.findElement(purchaseBtn).click();
	}

	public void validateTotalAmount(double price) {
		teacher.setOrderTotal(teacher.getSeats() * teacher.getYears() * price);
		Assert.assertEquals("$"+teacher.getOrderTotal(), driver.findElement(totalAmountToPay).getText());
	}

	public String getPaymentCompleteHeaderText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentCompleteHeader));
		return driver.findElement(paymentCompleteHeader).getText();
	}

	public void validatePaymentDetails() {
		String name = prop.getProperty("LastName") + ", " + prop.getProperty("FirstName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt));
		Assert.assertEquals(name, driver.findElement(nameTxt).getText());
		Assert.assertEquals(prop.getProperty("Email"), driver.findElement(emailTxt).getText());
		System.out.println(teacher.getEmail());
		System.out.println(teacher.getLastName());
		
		teacher.setLicenseKey(driver.findElement(licenseKeyTxt).getText());
		System.out.println("License Key for the Purchase is :" + teacher.getLicenseKey());
		Assert.assertFalse(teacher.getLicenseKey().isEmpty());
		
		teacher.setOrderNumber(driver.findElement(orderNumberTxt).getText());
		System.out.println("Order Number for the purchase is : " + teacher.getOrderNumber());
		Assert.assertFalse(teacher.getOrderNumber().isEmpty());
		Assert.assertEquals("$"+teacher.getOrderTotal(), driver.findElement(orderTotalTxt).getText());
	}

	public boolean validateProAccount() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(defaultProIcon));
		return driver.findElement(defaultProIcon).isDisplayed() 
				&&
				driver.findElement(licenseKeyTxt).getText().equals(teacher.getLicenseKey());
	}

	public void clickOnButton(String btn) throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(ElementUtil.getPath(btn)));
		driver.findElement(ElementUtil.getPath(btn)).click();
	}

	public void enterPwdToDeleteAcct() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInPopUp));
		driver.findElement(passwordInPopUp).sendKeys(prop.getProperty("Password"));
		
		
	}


}
