package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;
import com.util.ConfigReader;

public class QuizzesPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	
	private By quizzesTab = By.cssSelector(("#header-nav ul li:nth-child(2)"));
	private By pageTitle = By.cssSelector(".quizzes-header-text");
	private By addQuizBtn = By.xpath("//button[text()='ADD QUIZ']");
	private By createNewBtn = By.xpath("//span[text()='Create New']");
	private By importBtn = By.xpath("//span[text()='Import']");
	private By quizTitle = By.cssSelector("textarea[aria-label='Quiz Title']");
	private By enableSharingToggle = By.xpath("//div[text()='Enable Sharing']");
	private By alignQuizToggle = By.xpath("//p[text()='Align Quiz to Standard']");
	
	// Common Functionalities of all Question Types
	private By deleteQuestion = By.cssSelector("button[aria-label='Delete Question']");
	private By editQuestion = By.cssSelector("button[aria-label='Edit Question']");
	private By copyQuestion = By.cssSelector("button[aria-label='Copy Question']");
	private By moveQuestionUp = By.cssSelector("button[aria-label='Move Question Up']");
	private By moveQuestionDown = By.cssSelector("button[aria-label='Move Question Down']");
	private By MCExplanation = By.cssSelector("div[data-placeholder = 'An explanation, if you like.']");
	private By QuestionImage = By.cssSelector("input[aria-label ='Question Image']");
	private By ExplanationImage = By.cssSelector("input[aria-label ='Explanation Image']");
	private By AddAnswerBtn = By.xpath("//*contains(text(),'Add Answer')");
	private By SaveAndExitBtn = By.xpath("//*[contains(text() ,'Save and Exit')]");
	
	//Multiple Choice Question
	private By MCQuestion = By.xpath("//span[text()='MC']");
	private By MultipleChoiceQuestionBtn  = By.xpath("//*[contains(text(), 'Multiple Choice')]");
	private By MCQuestionWindow = By.cssSelector("div[data-question = 'MC']");
	private By MCQToAsk = By.cssSelector("div[data-placeholder = 'Have a multiple-choice question to ask?']");
	private By MCQAnswerA = By.cssSelector("div[data-placeholder = 'Answer A'");
	private By MCQAnswerB = By.cssSelector("div[data-placeholder = 'Answer B'");
	private By MCQAnswerC = By.cssSelector("div[data-placeholder = 'Answer C'");
	private By MCQAnswerD = By.cssSelector("div[data-placeholder = 'Answer D'");
	private By CorrectAnswerRadioBtn = By.cssSelector("input[aria-label='Correct']");
		
	// True False Question
	private By TFQuestion = By.xpath("//span[text()='TF']");
	private By TFQuestionWindow = By.cssSelector("div[data-question = 'MC']");
	private By TrueFalseQuestionBtn = By.xpath("//*[contains(text(), 'True / False')]");
	private By TFQToAsk = By.cssSelector("div[data-placeholder = 'Have a true-or-false question to ask?']");
	private By TrueBtn = By.cssSelector("input[value='true']");
	private By FalseBtn = By.cssSelector("input[value = 'false']");
	
	// Short Answer Question
	private By SAQuestion = By.xpath("//span[text()='SA']");	
	private By SAQuestionWindow = By.cssSelector("div[data-question = 'SA']");
	private By ShortAnswerQuestionBtn = By.xpath("//*[contains(text(), 'Short Answer')]");
	private By SAQToAsk = By.cssSelector("div[data-placeholder = 'Have a short-answer question to ask?']");
	private By SACorrectAnswers = By.cssSelector("input[placeholder = 'Correct Answer (Optional)']");
	
	
	
	public QuizzesPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}
	
	public void clickOnQuizzesTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizzesTab));
		driver.findElement(quizzesTab).click();
	}
	
	public String verifyPageTitle(String title)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		return driver.findElement(pageTitle).getText();
	}
	
	public void clickOnAddQuiz()
	{
		driver.findElement(addQuizBtn).click();
	}
	
	public void clickOnCreateNew()
	{
		Assert.check(driver.findElement(importBtn).isDisplayed());
		driver.findElement(createNewBtn).click();
	}
	
	public String getQuizTitle()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(quizTitle));
		return driver.findElement(quizTitle).getText();
	}
	
	public void verifyToggles()
	{
		WebElement sharingToggle = driver.findElement(enableSharingToggle);
		Assert.check(sharingToggle.isEnabled());
		sharingToggle.click();
		sharingToggle.click();
		
		WebElement alignToggle = driver.findElement(alignQuizToggle);
		Assert.check(alignToggle.isDisplayed());
		alignToggle.click();
		alignToggle.click();
	}
	
	public void verifyQuestionTypes()
	{
		Assert.check(driver.findElement(MCQuestion).isDisplayed());
		Assert.check(driver.findElement(TFQuestion).isDisplayed());
		Assert.check(driver.findElement(SAQuestion).isDisplayed());
	}
	
	public void enterQuizName()
	{
		driver.findElement(quizTitle).clear();
		driver.findElement(quizTitle).sendKeys(prop.getProperty("QuizName"));
	}
	
	public void enterMCTypeQuestion()
	{
		driver.findElement(MCQuestion).click();
	}
	
	public boolean verifyMCTypeOptions()
	{
		return driver.findElement(MCQuestionWindow).isDisplayed();
	}
}
