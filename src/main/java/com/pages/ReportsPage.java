package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.CommonUtils;
import com.util.ConfigReader;

public class ReportsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	private By reportsTab = By.xpath(("//span[text()='Reports']"));
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
	
	public ReportsPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}


	public void clickOnButton(String button) 
	{
		By BackToResultsTabBtn = By.xpath("//div[contains(text(),'"+button+"')]/parent::*");
		driver.findElement(BackToResultsTabBtn).click();
		
	}

	public void clickOnQuestion(int questionNumber) {
		driver.findElement(By.cssSelector("a[href*='questions/"+questionNumber+"']")).click();;
	}

	public void navigateBetweenQuestions() {
		wait.until(ExpectedConditions.elementToBeClickable(NextQuestionBtn));
		driver.findElement(NextQuestionBtn).click();
		driver.findElement(NextQuestionBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(PreviousQuestionBtn));
		driver.findElement(PreviousQuestionBtn).click();
	}

}
