package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;
import com.util.ConfigReader;

public class LaunchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	
	private By launchTab = By.cssSelector(("#header-nav ul li:nth-child(1)"));
	private By QuizBtn = By.xpath("//span[text() = 'Quiz']");
	private By ExitTicketBtn = By.xpath("//span[text() = 'Exit Ticket']");
	private By MCBtn = By.xpath("//span[text() = 'Multiple Choice']");
	private By TFBtn = By.xpath("//span[text() = 'True / False']");
	
	// Short Answer Quick Question
	private By SABtn = By.xpath("//span[text() = 'Short Answer']");
	private By SAPopUpBox = By.id("sa-popup-box");
	private By optionalQuestion = By.id("saQuestion");
	private By SAStartBtn = By.xpath("//button[text()='START']");
	private By SACancelBtn = By.xpath("//button[text()='CANCEL']");
	
	// Common Functionalities 
	private By nextBtn = By.xpath("//*[contains(text() ,'Next')]");
	private By previousBtn = By.xpath("//*[contains(text() ,'Previous')]");
	private By searchQuizzesField = By.cssSelector("input[placeholder='Search Quizzes']");
	private By clearSearchBtn = By.cssSelector("clear-search");
	private By startBtn = By.xpath("//button[text()='Start']");
	
	//Delivery Method and Settings
	private By InstantFeedbackBtn = By.xpath("//*[contains(text() ,'Instant Feedback')]");
	private By OpenNavigationBtn = By.xpath("//*[contains(text() ,'Open Navigation')]");
	private By TeacherPacedBtn = By.xpath("//*[contains(text() ,'Teacher Paced')]");
	private By RequireNamesToggle = By.xpath("//*[contains(text() ,'Require Names')]");
	private By ShuffleQuestionsToggle = By.xpath("//*[contains(text() ,'Shuffle Questions')]");
	private By ShuffleAnswersToggle = By.xpath("//*[contains(text() ,'Shuffle Answers')]");
	private By ShowQuestionFeedbackToggle = By.xpath("//*[contains(text() ,'Show Question Feedback')]");
	private By ShowFinalScoreToggle = By.xpath("//*[contains(text() ,'Show Final Score')]");
	private By OneAttemptToggle = By.xpath("//*[contains(text() ,'One Attempt')]");
	
	// Space Race Settings
	private By SpaceRaceBtn = By.xpath("//span[text() = 'Space Race']");
	private By teams = By.cssSelector("input[value='Number of Teams']");
	private By studentChoiceBtn = By.xpath("//span[text()='Student Choice']");
	private By autoAssignBtn = By.xpath("//span[text()='Auto-assign']");
	private By icon = By.cssSelector("input[value='Rocket']");
	private By countdown = By.cssSelector("input[value='None']");
	
	
	public LaunchPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}
	
	public void clickOnLaunchTab()
	{
		wait.until(ExpectedConditions.elementToBeClickable(launchTab));
		driver.findElement(launchTab).click();
	}
	
	public void clickOnQuizBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(QuizBtn));
		driver.findElement(QuizBtn).click();
	}
	
	public void selectQuizFromList()
	{
		By quizName = By.xpath("//span[text()='"+prop.getProperty("QuizName")+"']");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizName));
		Assert.check(driver.findElement(quizName).isDisplayed());
		driver.findElement(quizName).click();
	}
	
	public void clickOnNextBtn() {
		driver.findElement(nextBtn).click();
	}
	
	public void selectDeliverySettings(String method)
	{
		By deliveryMethod = By.xpath("//span[contains(text() ,'"+method+"')]");
		wait.until(ExpectedConditions.elementToBeClickable(deliveryMethod));
		driver.findElement(deliveryMethod).click();
	}
	
	public void clickOnStartBtn()
	{
		driver.findElement(startBtn).click();
	}
	
	public void clickOnSABtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SABtn));
		driver.findElement(SABtn).click();
	}

	public boolean verifySAView() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SAPopUpBox));
		return driver.findElement(SAPopUpBox).isDisplayed();
	}

	public void enterOptionalQuestion() {
		String question = prop.getProperty("OptionalQuestion");
		wait.until(ExpectedConditions.visibilityOfElementLocated(optionalQuestion));
		driver.findElement(optionalQuestion).sendKeys(question);
	}

	public void selectToggles(String toggle1, String toggle2) {
		By unlimitedResponsesBtn = By.xpath("//label[contains(text(),'"+toggle1+"')]");
		By requireStudentNamesBtn = By.xpath("//label[contains(text(),'"+toggle2+"')]");
		
		driver.findElement(unlimitedResponsesBtn).click();
		driver.findElement(requireStudentNamesBtn).click();
	}

	public void clickOnSAStartBtn() {
		driver.findElement(SAStartBtn).click();
	}

	public boolean verifyQuickQuestionText(String text) {
		By qqtext = By.xpath("//h1[text()='"+text+"']");
		return driver.findElement(qqtext).isDisplayed();
	}

	public boolean verifyButtons(String button1, String button2, String button3) {
		By b1 = By.xpath("//button[text()='"+button1+"']");
		By b2 = By.xpath("//button[text()='"+button2+"']");
		By b3 = By.xpath("//button[text()='"+button3+"']");
		
		return driver.findElement(b1).isDisplayed() && driver.findElement(b2).isDisplayed() && driver.findElement(b3).isDisplayed();
	}

	public void clickOnSpaceRace() {
		wait.until(ExpectedConditions.elementToBeClickable(SpaceRaceBtn));
		driver.findElement(SpaceRaceBtn).click();
	}

	public void selectSpaceRaceSettings() {
		driver.findElement(teams).click(); 
		driver.findElement(By.xpath("//li[.//span[text()='"+prop.getProperty("noOfTeams")+"']]")).click();;
	}
	
}
