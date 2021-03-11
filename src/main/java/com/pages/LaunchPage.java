package com.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.util.ConfigReader;
import com.util.ElementUtil;

public class LaunchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	
	private By launchTab = By.cssSelector(("#header-nav ul li:nth-child(1)"));
	private By quizBtn = By.xpath("//span[text() = 'Quiz']");
	private By exitTicketBtn = By.xpath("//span[text() = 'Exit Ticket']");
	private By mcBtn = By.xpath("//span[text() = 'Multiple Choice']");
	private By tfBtn = By.xpath("//span[text() = 'True / False']");
	
	// Short Answer Quick Question
	private By saBtn = By.xpath("//span[text() = 'Short Answer']");
	private By saPopUpBox = By.id("sa-popup-box");
	private By optionalQuestion = By.id("saQuestion");
	private By saStartBtn = By.xpath("//button[text()='START']");
	private By saCancelBtn = By.xpath("//button[text()='CANCEL']");
	
	// Common Functionalities 
	private By nextBtn = By.xpath("//*[contains(text() ,'Next')]");
	private By previousBtn = By.xpath("//*[contains(text() ,'Previous')]");
	private By searchQuizzesField = By.cssSelector("input[placeholder='Search Quizzes']");
	private By clearSearchBtn = By.cssSelector("clear-search");
	private By startBtn = By.xpath("//button[text()='Start']");
	
	//Delivery Method and Settings
	private By instantFeedbackBtn = By.xpath("//span[text()='Instant Feedback']");
	private By openNavigationBtn = By.xpath("//span[text()='Open Navigation']");
	private By teacherPacedBtn = By.xpath("//span[text()='Teacher Paced']");
	private By requireNamesToggle = By.xpath("//label[text()='Require Names']");
	private By shuffleQuestionsToggle = By.xpath("//label[text()='Shuffle Questions']");
	private By shuffleAnswersToggle = By.xpath("//label[text()='Shuffle Answers']");
	private By showQuestionFeedbackToggle = By.xpath("//label[text() = 'Show Question Feedback']");
	private By showFinalScoreToggle = By.xpath("//label[text()='Show Final Score']");
	private By oneAttemptToggle = By.xpath("//label[text()='One Attempt']");
	
	// Space Race Settings
	private By spaceRaceBtn = By.xpath("//span[text() = 'Space Race']");
	private By teams = By.cssSelector("input[value='Number of Teams']");
	private By studentChoiceBtn = By.xpath("//span[text()='Student Choice']");
	private By autoAssignBtn = By.xpath("//span[text()='Auto-assign']");
	private By icon = By.cssSelector("input[value='Rocket']");
	private By countdown = By.cssSelector("input[value='None']");
	
	
	public LaunchPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
	}
	
	public void clickOnLaunchTab()
	{
		wait.until(ExpectedConditions.elementToBeClickable(launchTab));
		driver.findElement(launchTab).click();
	}
	
	public void clickOnQuizBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizBtn));
		driver.findElement(quizBtn).click();
	}
	
	public void selectQuizFromList()
	{
		By quizName = ElementUtil.getPath(prop.getProperty("QuizName"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizName));
		Assert.assertTrue(driver.findElement(quizName).isDisplayed());
		driver.findElement(quizName).click();
	}
	
	public void clickOnNextBtn() {
		driver.findElement(nextBtn).click();
	}
	
	public void selectDeliverySettings(String method)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ElementUtil.getPath(method)));
		driver.findElement(ElementUtil.getPath(method)).click();
	}
	
	public void clickOnStartBtn()
	{
		driver.findElement(startBtn).click();
	}
	
	public void clickOnSABtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(saBtn));
		driver.findElement(saBtn).click();
	}

	public boolean verifySAView() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(saPopUpBox));
		return driver.findElement(saPopUpBox).isDisplayed();
	}

	public void enterOptionalQuestion() {
		String question = prop.getProperty("OptionalQuestion");
		wait.until(ExpectedConditions.visibilityOfElementLocated(optionalQuestion));
		driver.findElement(optionalQuestion).sendKeys(question);
	}

	public void selectToggles(String toggle1, String toggle2) {
		driver.findElement(ElementUtil.getPath(toggle1)).click();
		driver.findElement(ElementUtil.getPath(toggle2)).click();
	}

	public void clickOnSAStartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saStartBtn));
		driver.findElement(saStartBtn).click();
	}

	public boolean verifyQuickQuestionText(String text) {
		return driver.findElement(ElementUtil.getPath(text)).isDisplayed();
	}

	public boolean verifyButtons(String button1, String button2, String button3) {	
		return driver.findElement(getButtonText(button1)).isDisplayed() && driver.findElement(getButtonText(button2)).isDisplayed() && driver.findElement(getButtonText(button3)).isDisplayed();
	}

	public By getButtonText(String button)
	{
		return ElementUtil.getPath(button);
	}
	
	public void clickOnSpaceRace() {
		wait.until(ExpectedConditions.elementToBeClickable(spaceRaceBtn));
		driver.findElement(spaceRaceBtn).click();
	}

	public void selectSpaceRaceSettings() {
		driver.findElement(teams).click(); 
		driver.findElement(By.xpath("//li[.//span[text()='"+prop.getProperty("noOfTeams")+"']]")).click();
	}
	
}
