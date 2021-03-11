package com.showbiePages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.ConfigReader;

import pojo.Teacher;

public class ShowbiePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private String className = null;
	private String clsCode = null;
	private Teacher teacher;
	
	// LoginPage
	By signInText = By.xpath("//p[text()='Sign In']");
	By email = By.id("sign-up-email");
	By password = By.id("sign-up-password");
	By signInBtn = By.xpath("//span[text() ='Sign In']/ancestor::button");
	
	// Showbie Page
	By homePageTitle = By.className("nav-header__title");
	By wrenchBtn = By.cssSelector("button.wrench");
	By newClassBtn = By.xpath("//div[text()='New Class']//ancestor::button");
	By joinAClassBtn = By.xpath("//div[text()='Join a Class']//ancestor::button");
	By showArchivedBtn = By.className("onoffswitch-toggle");
	By newClassTxt = By.cssSelector("input[placeholder='New Class']");
	By cancelBtn = By.xpath("//button[text()='Cancel']");
	By saveBtn = By.xpath("//button[text()='Save']");
	By classCode = By.xpath("//span[text()='Class Code']/ancestor::span/div");
	By parentAccessToggle = By.xpath("//span[text()='Parent Access']//following-sibling::span");
	By studentLedPortfolioToggle = By.xpath("//span[text()='Student-Led Portfolios']//following-sibling::span");
	
	// New Assignment
	By toolTipText = By.className("guide-tip__content");
	By newAssignmentBtn = By.xpath("//div[text()='New Assignment']/ancestor::button");
	By newFolderBtn = By.xpath("//div[text()='New Folder']/ancestor::button");
	By classSettingsBtn = By.xpath("//div[text()='Class Settings']/ancestor::button");
	By assignmentForm = By.className("assignment-form");
	By title = By.cssSelector("input[placeholder='New Assignment']");
	By assignmentDate = By.className("sbe-due-date-picker__date");
	By assignmentTime = By.className("sbe-due-date-picker__time");
	
	//Student Access
	By studentAccessLocked = By.xpath("//*[contains(@href,'aas-locked')]/ancestor::button");
	By studentAccessViewOnly = By.xpath("//*[contains(@href,'aas-view-only')]/ancestor::button");
	By studentAccessEditable = By.xpath("//*[contains(@href,'aas-editable')]/ancestor::button");
	By sharedItemsFolder = By.xpath("//h1[text()='Shared Items']");
	By detailHeaderTxt = By.className("detail-header__text");
	By commentTxtArea = By.cssSelector("textarea[placeholder='write a comment…']");
	By postBtn = By.className("post-form__submit-button");
	By postContent = By.cssSelector("div.content__body--readonly p");
	
	//Add Post
	By addPostBtn = By.xpath("//span[text()='add post']/ancestor::button");
	By addNewDocumentBtn = By.xpath("//span[text()='New Document']/ancestor::button");
	By addGradeBtn = By.xpath("//span[text()='Grade']/ancestor::button");
	By addQuizBtn = By.xpath("//span[text()='Quiz']/ancestor::button");
	
	
	public ShowbiePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
		teacher = new Teacher();
	}

	public String verifyShowbieLoginPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInText));
		return driver.findElement(signInText).getText();
	}

	public void enterEmail(String username) {
		driver.findElement(email).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnSignInBtn() {
		driver.findElement(signInBtn).click();
	}

	public String verifyShowbieHomePageText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(wrenchBtn));
		System.out.println(driver.findElement(homePageTitle).getText());
		return driver.findElement(homePageTitle).getText();
	}

	public void clickOnWrenchBtn() {
		driver.findElement(wrenchBtn).click();
	}

	public void clickOnNewClassBtn() {
		driver.findElement(newClassBtn).click();
	}

	public boolean verifyNewClassWindow(String window) {
		By classWindow = By.xpath("//h1[text()='"+window+"']");
		return driver.findElement(classWindow).isDisplayed();
	}

	public void enterClassName() {
		className = prop.getProperty("className");
		wait.until(ExpectedConditions.visibilityOfElementLocated(newClassTxt));
		driver.findElement(newClassTxt).sendKeys(className);
	}

	public boolean verifyNewClassDefaultOptions() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(classCode));
		teacher.setClassCode(driver.findElement(classCode).getText());
		return  ((!teacher.getClassCode().isEmpty()) && driver.findElement(cancelBtn).isDisplayed() && driver.findElement(studentLedPortfolioToggle).isEnabled() && (!driver.findElement(parentAccessToggle).isSelected()));
	}
	
	public void clickOnSaveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		driver.findElement(saveBtn).click();
	}

	public boolean verifyClassInTheList() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipText));
		return driver.findElement(homePageTitle).getText().equalsIgnoreCase(className);
	}

	public String getToolTipText() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipText));
		System.out.println(driver.findElement(toolTipText).getText());
		return driver.findElement(toolTipText).getText();
	}

	public void clickOnNewAssignmentBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(newAssignmentBtn));
		driver.findElement(newAssignmentBtn).click();
	}

	public boolean verifyNewAssignmentWindow() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(assignmentForm));
		return driver.findElement(assignmentForm).isDisplayed();
	}

	public void enterAssignmentName() {
		teacher.setAssignmentName(prop.getProperty("assignmentName"));
		driver.findElement(title).sendKeys(teacher.getAssignmentName());
	}

	public void enterDueDateAndTime() {
		teacher.setDueDate(prop.getProperty("dueDate"));
		teacher.setDueTime(prop.getProperty("dueTime"));
		//driver.findElement(assignmentDate).sendKeys(teacher.getDueDate());
	//	driver.findElement(assignmentTime).sendKeys(teacher.getDueTime());
	
	}

	public void enterStudentAccess() {
		teacher.setStudentAccess(prop.getProperty("StudentAccess"));
		String access = null;
		
		switch(teacher.getStudentAccess())
		{
			case "Editable" : 
				access = "aas-editable";
				break;
			case "View-Only" : 
				access = "aas-view-only";
				break;
			case "Locked" : 
				access = "aas-locked";
				break;
			default:
				System.err.println("Incorrect Student Access: "+teacher.getStudentAccess());	 
		}
		
		driver.findElement(By.xpath("//*[contains(@href,'"+access+"')]/ancestor::button")).click();
	}

	public boolean verifyAssignmentDetailsUnderAssigned() {
		return driver.findElement(By.xpath("//h1[text()='"+teacher.getAssignmentName()+"']")).isDisplayed();
	}

	public void selectAssignment() {
		driver.findElement(By.xpath("//h1[text()='"+teacher.getAssignmentName()+"']")).click();
	}

	public boolean verifyAssignmentNameOnHeader() {
		wait.until(ExpectedConditions.presenceOfElementLocated(homePageTitle));
		return driver.findElement(homePageTitle).getText().equalsIgnoreCase(teacher.getAssignmentName());
	}

	public boolean verifyFolder(String folder) {
		return driver.findElement(sharedItemsFolder).getText().equalsIgnoreCase(folder);
	}

	public void clickOnSharedItemsFolder() {
		driver.findElement(sharedItemsFolder).click();
	}

	public boolean verifyPage(String page) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(detailHeaderTxt));
		return driver.findElement(detailHeaderTxt).getText().equalsIgnoreCase(page);
	}

	public boolean verifyTextArea(String comment) {
		By commentArea = By.cssSelector("textarea[placeholder='"+comment+"']");
		return driver.findElement(commentArea).isDisplayed();
	}

	public void enterComment() {
		teacher.setComment(prop.getProperty("comment"));
		driver.findElement(commentTxtArea).sendKeys(teacher.getComment());
	}

	public void clickOnPostBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(postBtn));
		driver.findElement(postBtn).click();
	}

	public boolean validatePostInThePostContainer() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(postContent));
		return driver.findElement(postContent).getText().equalsIgnoreCase(teacher.getComment());
	}

	public void clickonAddPostBtn() {
		driver.findElement(addPostBtn).click();
	}
	
	
	
}
