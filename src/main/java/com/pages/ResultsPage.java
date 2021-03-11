package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;
import com.util.ConfigReader;

public class ResultsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	private By resultsTab = By.xpath(("//span[text()='Results']"));
	private By animatedWifiSymbol = By.cssSelector(".animated-wifi-symbol");
	private By wifiSymbol = By.cssSelector(".wifi-symbol");
	private By finishBtn = By.xpath("//*[contains(text(),'Finish')]");
	private By showNamesToggle = By.xpath("//span[contains(text() ,'Show Names')]");
	private By showResponsesToggle = By.xpath("//span[contains(text() ,'Show Names')]");
	private By showResultsToggle = By.xpath("//span[contains(text() ,'Show Names')]");
	private By nextQuestionBtn = By.cssSelector("button[aria-label = 'Next Question']");
	private By previousQuestionBtn = By.cssSelector("button[aria-label = 'Previous Question']");
	private By backToResultsTabBtn = By.xpath("//*[contains(text(),'Back to Results Tab')]");
	private By showResultsBtn = By.xpath("//button[contains(text(),'Show Results')]");
	private By showAnswersBtn = By.xpath("//button[contains(text(),'Show Answers')]");
	private By showNamesBtn = By.xpath("//button[contains(text(),'Show Names')]");
	private By scoreSelectBtn = By.id("score-select");
	private By namesAscending = By.xpath("//span[contains(text(),'ascending')]");
	private By shareBtn = By.xpath("//div[contains(text(),'Share')]");
	private By exportBtn = By.xpath("//div[contains(text(),'Export')]");
	private By launchActivityBtn = By.xpath("//button[text()='Launch Activity']");
	private By closeActivityOKBtn = By.xpath("//button[text() = 'OK']");
	private By spaceRaceHeaderName = By.cssSelector(".space-race-header-text");
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
	}
	
	public boolean verifyQuizName()
	{
		By quizName = By.xpath("//h1[contains(text(),'"+prop.getProperty("QuizName")+"')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizName));
		return driver.findElement(quizName).isDisplayed();
	}
	
	public boolean verifyActivity(String activityType)
	{
		if (activityType.equalsIgnoreCase("Active")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(animatedWifiSymbol));
			return driver.findElement(animatedWifiSymbol).isDisplayed();
		}
		else if(activityType.equalsIgnoreCase("InActive")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(wifiSymbol));
			return driver.findElement(wifiSymbol).isDisplayed();
		}
		else
			System.out.println("Invalid Type :"+activityType+" for the activity");
		return false;			
	}
	
	public void verifyToggles(String message)
	{
		if(message.equalsIgnoreCase("Active Activity")) {
		Assert.check(driver.findElement(showNamesToggle).isEnabled());
		Assert.check(driver.findElement(showResponsesToggle).isEnabled());
		Assert.check(driver.findElement(showResultsToggle).isEnabled());
		}
		else if(message.equalsIgnoreCase("After Activity")) {
			Assert.check(!driver.findElement(showNamesToggle).isSelected());
			Assert.check(!driver.findElement(showResponsesToggle).isSelected());
			Assert.check(!driver.findElement(showResultsToggle).isSelected());
		}
	}
	
	public void selectScoreByMethod(String method)
	{
		Select score = new Select(driver.findElement(scoreSelectBtn));
		score.selectByVisibleText("Progress");
		//score.selectByVisibleText("Score %");
		//score.selectByVisibleText("Score #");
		//score.selectByIndex(0); //Progress
	}
	
	public void clickOnFinishBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
		driver.findElement(finishBtn).click();
	}
	
	public boolean verifyFinishPopup(String popup)
	{
		By popupMessage = By.xpath("//div[contains(text(),'"+popup+"')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(popupMessage));
		return driver.findElement(popupMessage).isDisplayed();
	}
	
	public void clickOnButtonInPopUp(String popupBtn)
	{
		By popUpFinishBtn = By.xpath("//button[contains(text(),'"+popupBtn+"')]");
		wait.until(ExpectedConditions.elementToBeClickable(popUpFinishBtn));
		driver.findElement(popUpFinishBtn).click();
	}
	
	public boolean verifyShareBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareBtn));
		return driver.findElement(shareBtn).isDisplayed();
	}
	public boolean verifyExportBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(exportBtn));
		return driver.findElement(exportBtn).isDisplayed();
	}

	public void clickOnResultsTab() {
		wait.until(ExpectedConditions.elementToBeClickable(resultsTab));
		driver.findElement(resultsTab).click();
	}

	public void clickOnLaunchActivity() {
		wait.until(ExpectedConditions.elementToBeClickable(launchActivityBtn));
		driver.findElement(launchActivityBtn).click();
	}

	public boolean verifySpaceRaceSettings() {
		By sections = By.cssSelector(".rocket-wrap");
		int size = driver.findElements(sections).size();
		return prop.getProperty("noOfTeams").equals(String.valueOf(size));
	}

	public void clickOnOKButton() {
		wait.until(ExpectedConditions.elementToBeClickable(closeActivityOKBtn));
		driver.findElement(closeActivityOKBtn).click();
	}

	public String verifySpaceRaceHeaderName() {
		return driver.findElement(spaceRaceHeaderName).getText();
	}

	public boolean validateStudentResponses() {
		By response1 = By.xpath("//span[text()='"+prop.getProperty("student1Answer1")+"']");
		By response2 = By.xpath("//span[text()='"+prop.getProperty("student1Answer1")+"']");
		By response3 = By.xpath("//span[text()='"+prop.getProperty("student1Answer1")+"']");
		
		return driver.findElement(response1).isDisplayed() && driver.findElement(response2).isDisplayed() && driver.findElement(response3).isDisplayed();
	}
	
}
