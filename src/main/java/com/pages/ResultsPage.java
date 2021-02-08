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
	
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}
	
	public boolean verifyLaunchQuiz()
	{
		By quizName = By.xpath("//h1[contains(text(),'"+prop.getProperty("QuizName")+"')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizName));
		return driver.findElement(quizName).isDisplayed();
	}
	
	public boolean verifyActiveActivity()
	{
		return driver.findElement(animatedWifiSymbol).isDisplayed();
	}
	
	public void verifyToggles()
	{
		Assert.check(driver.findElement(ShowNamesToggle).isEnabled());
		Assert.check(driver.findElement(ShowResponsesToggle).isEnabled());
		Assert.check(driver.findElement(ShowResultsToggle).isEnabled());
	}
	
	public void selectScoreByMethod()
	{
		Select score = new Select(driver.findElement(ScoreSelectBtn));
		score.selectByVisibleText("Progress");
		//score.selectByVisibleText("Score %");
		//score.selectByVisibleText("Score #");
		//score.selectByIndex(0); //Progress
	}
}
