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
	
	private By animatedWifiSymbol = By.cssSelector(".animated-wifi-symbol");
	private By wifiSymbol = By.cssSelector(".wifi-symbol");
	private By FinishBtn = By.xpath("//div[contains(text(),'Finish')]");
	private By ShowNamesToggle = By.xpath("//span[contains(text() ,'Show Names')]");
	private By ShowResponsesToggle = By.xpath("//span[contains(text() ,'Show Names')]");
	private By ShowResultsToggle = By.xpath("//span[contains(text() ,'Show Names')]");
	private By NextQuestionBtn = By.cssSelector("button[aria-label = 'Next Question']");
	private By PreviousQuestionBtn = By.cssSelector("button[aria-label = 'Previous Question']");
	private By BackToResultsTabBtn = By.xpath("//*[contains(text(),'Back to Results Tab')]");
	private By ShowResultsBtn = By.xpath("//button[contains(text(),'Show Results')]");
	private By ShowAnswersBtn = By.xpath("//button[contains(text(),'Show Answers')]");
	private By ShowNamesBtn = By.xpath("//button[contains(text(),'Show Names')]");
	private By ScoreSelectBtn = By.id("score-select");
	private By NamesAscending = By.xpath("//span[contains(text(),'ascending')]");
	private By ShareBtn = By.xpath("//div[contains(text(),'Share')]");
	private By ExportBtn = By.xpath("//div[contains(text(),'Export')]");
	
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
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
		Assert.check(driver.findElement(ShowNamesToggle).isEnabled());
		Assert.check(driver.findElement(ShowResponsesToggle).isEnabled());
		Assert.check(driver.findElement(ShowResultsToggle).isEnabled());
		}
		else if(message.equalsIgnoreCase("After Activity")) {
			Assert.check(!driver.findElement(ShowNamesToggle).isSelected());
			Assert.check(!driver.findElement(ShowResponsesToggle).isSelected());
			Assert.check(!driver.findElement(ShowResultsToggle).isSelected());
		}
	}
	
	public void selectScoreByMethod(String method)
	{
		Select score = new Select(driver.findElement(ScoreSelectBtn));
		score.selectByVisibleText("Progress");
		//score.selectByVisibleText("Score %");
		//score.selectByVisibleText("Score #");
		//score.selectByIndex(0); //Progress
	}
	
	public void clickOnFinishBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(FinishBtn));
		driver.findElement(FinishBtn).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShareBtn));
		return driver.findElement(ShareBtn).isDisplayed();
	}
	public boolean verifyExportBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExportBtn));
		return driver.findElement(ExportBtn).isDisplayed();
	}
	
}
