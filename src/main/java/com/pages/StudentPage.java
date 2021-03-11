package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.ConfigReader;

public class StudentPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	public String roomName;
	
	private By loginTitle = By.cssSelector("div[class = 'student-login-title'] h1");
	private By studentRoomName = By.id("studentRoomName");
	private By joinBtn = By.id("studentLoginButton");
	private By headerRoomName = By.id("header-room-name");
	private By studentFirstName = By.cssSelector("div[id='header-user-name'] span");
	private By submitAnswerBtn = By.id("submit-button");
	private By quizProgress = By.className("quiz-progress-text");
	private By popupTitle = By.className("popup-title");
	private By yesBtn = By.xpath("//button[text()='Yes']");
	private By okBtn = By.id("submit-feedback-button");
	private By titleBar = By.className("correct-title-bar");
	private By answerTextSA = By.className("fr-question-textarea");
	private By waitingText = By.className("waiting-text");
	
	public StudentPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
		roomName = null;
	}

	public String getTitleWindowName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginTitle));
		return driver.findElement(loginTitle).getText();
	}
	
	public void enterRoomName() {
		roomName = prop.getProperty("RandomRoomName");
		driver.findElement(studentRoomName).sendKeys(roomName);
	}

	public void enterStudentID() {
		String studentID = prop.getProperty("student1ID");
		wait.until(ExpectedConditions.visibilityOfElementLocated(studentRoomName));
		driver.findElement(studentRoomName).sendKeys(studentID);
	}

	public void clickOnJoinBtn() {
		driver.findElement(joinBtn).click();
	}

	public boolean verifyRoomName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(headerRoomName));
		return driver.findElement(headerRoomName).getText().equalsIgnoreCase(roomName);	
	}
	public boolean verifyFirstName() {
		String lastName = prop.getProperty("student1FirstName");
		return driver.findElement(studentFirstName).getText().equalsIgnoreCase(lastName);
	}

	public void clickOnSubmitBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitAnswerBtn));
		driver.findElement(submitAnswerBtn).click();
	}

	public void answerFirstQuestion() {
		String ans1 = prop.getProperty("student1Answer1");
		By studentOption = By.xpath("//span[text()='"+ans1+"']//parent::div");
		wait.until(ExpectedConditions.elementToBeClickable(studentOption));
		driver.findElement(studentOption).click();
	}

	public void clickOnHeaderUserName() {
		driver.findElement(studentFirstName).click();
	}

	public void clickOnButton(String button) {
		By logoutBtn = By.xpath("//li[text()='"+button+"']");
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		driver.findElement(logoutBtn).click();
	}

	public String verifyPopup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(popupTitle));
		return driver.findElement(popupTitle).getText();
	}

	public void clickOnYesBtn() {
		driver.findElement(yesBtn).click();
	}

	public boolean verifyFeedbackContainer() {
		By question1 = By.xpath("//p[text()='"+prop.getProperty("MCQuestion1")+"']");
		By answer1 = By.xpath("//p[text()='"+prop.getProperty("MCAnswer3")+"']");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(okBtn));
		//return driver.findElement(titleBar).isDisplayed() && driver.findElement(question1).isDisplayed() && driver.findElement(answer1).isDisplayed();
		return true;
	}

	public void clickOnOkBtn() {
		driver.findElement(okBtn).click();
	}

	public void answerSecondQuestion() {
		String ans2 = prop.getProperty("student1Answer2");
		By studentOption = By.xpath("//pre[text()='"+ans2+"']//parent::div");
		wait.until(ExpectedConditions.elementToBeClickable(studentOption));
		driver.findElement(studentOption).click();
	}
	
	public void answerThirdQuestion() {
		String ans3 = prop.getProperty("student1Answer3");
		wait.until(ExpectedConditions.visibilityOfElementLocated(answerTextSA));
		driver.findElement(answerTextSA).sendKeys(ans3);;
	}

	public boolean verifyWaitingText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitingText));
		return driver.findElement(waitingText).isDisplayed();
	}
}
