package com.pages;

import java.util.List;
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
	
	
	private By quizzesTab = By.xpath(("//span[text() = 'Quizzes']"));
	private By pageTitle = By.cssSelector(".quizzes-header-text");
	private By addQuizBtn = By.xpath("//button[text()='ADD QUIZ']");
	private By createNewBtn = By.xpath("//span[text()='Create New']");
	private By importBtn = By.xpath("//span[text()='Import']");
	private By quizTitle = By.cssSelector("textarea[aria-label='Quiz Title']");
	private By enableSharingToggle = By.xpath("//div[text()='Enable Sharing']");
	private By alignQuizToggle = By.xpath("//p[text()='Align Quiz to Standard']");
	
	// Common Functionalities of all Question Types
	private By saveQuestion = By.cssSelector("button[aria-label='Save Question']");
	private By deleteQuestion = By.cssSelector("button[aria-label='Delete Question']");
	private By editQuestion = By.cssSelector("button[aria-label='Edit Question']");
	private By copyQuestion = By.cssSelector("button[aria-label='Copy Question']");
	private By moveQuestionUp = By.cssSelector("button[aria-label='Move Question Up']");
	private By moveQuestionDown = By.cssSelector("button[aria-label='Move Question Down']");
	private By ExplanationTextBox = By.cssSelector("div[data-placeholder = 'An explanation, if you like.']");
	private By QuestionImage = By.cssSelector("input[aria-label ='Question Image']");
	private By ExplanationImage = By.cssSelector("input[aria-label ='Explanation Image']");
	private By AddAnswerBtn = By.xpath("//*contains(text(),'Add Answer')");
	private By SaveAndExitBtn = By.xpath("//*[contains(text() ,'Save and Exit')]");
	//private By CorrectAnswerRadioBtn = By.cssSelector("input[aria-label='Correct']");
	private By CorrectAnswerRadioBtn = By.cssSelector(".checkbox-icon");
	private By addAQuestionText = By.xpath("//*[contains(text() ,'Add a Question')]");
	
	//Multiple Choice Question
	private By MCQuestion = By.xpath("//span[text()='MC']");
	private By MultipleChoiceQuestionBtn  = By.xpath("//button[contains(text(), 'Multiple Choice')]");
	private By MCQuestionWindow = By.cssSelector("div[data-question = 'MC']");
	private By MCQToAsk = By.cssSelector("div[data-placeholder = 'Have a multiple-choice question to ask?']");
	private By MCQAnswerA = By.cssSelector("div[data-placeholder = 'Answer A'");
	private By MCQAnswerB = By.cssSelector("div[data-placeholder = 'Answer B'");
	private By MCQAnswerC = By.cssSelector("div[data-placeholder = 'Answer C'");
	private By MCQAnswerD = By.cssSelector("div[data-placeholder = 'Answer D'");
		
	// True False Question
	private By TFQuestion = By.xpath("//span[text()='TF']");
	private By TFQuestionWindow = By.cssSelector("div[data-question = 'MC']");
	private By TrueFalseQuestionBtn = By.xpath("//button[contains(text(), 'True / False')]");
	private By TFQToAsk = By.cssSelector("div[data-placeholder = 'Have a true-or-false question to ask?']");
	private By TrueBtn = By.xpath("//span[contains(text(),'True')]");
	private By FalseBtn = By.xpath("//span[contains(text(),'False')]");
	
	// Short Answer Question
	private By SAQuestion = By.xpath("//span[text()='SA']");	
	private By SAQuestionWindow = By.cssSelector("div[data-question = 'FR']");
	private By ShortAnswerQuestionBtn = By.xpath("//button[contains(text(), 'Short Answer')]");
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
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void clickOnMCTypeQuestion()
	{
		driver.findElement(MCQuestion).click();
	}
	
	public void enterMCTypeQuestion()
	{
	    driver.findElement(MCQToAsk).click();
	    driver.findElement(MCQToAsk).sendKeys(prop.getProperty("MCQuestion1"));
	}
	
	public void enterAnswersForQuestion()
	{
		driver.findElement(MCQAnswerA).click();
		driver.findElement(MCQAnswerA).sendKeys(prop.getProperty("MCAnswer1"));
		
		driver.findElement(MCQAnswerB).click();
		driver.findElement(MCQAnswerB).sendKeys(prop.getProperty("MCAnswer2"));
		
		driver.findElement(MCQAnswerC).click();
		driver.findElement(MCQAnswerC).sendKeys(prop.getProperty("MCAnswer3"));
		
		driver.findElement(MCQAnswerD).click();
		driver.findElement(MCQAnswerD).sendKeys(prop.getProperty("MCAnswer4"));
	}
	
	public void selectCorrectMCAnswer()
	{
		List<WebElement> elements = driver.findElements(CorrectAnswerRadioBtn);
		System.out.println("List of Web Elements"+elements);
	
		elements.get(2).click();
	}
	
	public void clickOnSaveQuestion()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(saveQuestion));
		driver.findElement(saveQuestion).click();
	}
	
	public void validateQuestionView()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(editQuestion));
		Assert.check(driver.findElement(editQuestion).isDisplayed());
		Assert.check(driver.findElement(deleteQuestion).isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated(copyQuestion));
		Assert.check(driver.findElement(copyQuestion).isDisplayed());
	}
	
	public void validateQuestionTextAndTypes(String text)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(addAQuestionText));
		Assert.check(driver.findElement(addAQuestionText).getText().equals(text));
		Assert.check(driver.findElement(MultipleChoiceQuestionBtn).isDisplayed());
		Assert.check(driver.findElement(TrueFalseQuestionBtn).isDisplayed());
		Assert.check(driver.findElement(ShortAnswerQuestionBtn).isDisplayed());
	}
	
	public void clickOnTrueFalseQuestion()
	{
		wait.until(ExpectedConditions.elementToBeClickable(TrueFalseQuestionBtn));
		driver.findElement(TrueFalseQuestionBtn).click();
	}
	
	public void enterTFTypeQuestion()
	{
		driver.findElement(TFQToAsk).click();
		driver.findElement(TFQToAsk).sendKeys(prop.getProperty("TFQuestion1"));
	}
	
	public void selectCorrectTFAnswer()
	{
		Assert.check(driver.findElement(TrueBtn).isEnabled());
		driver.findElement(FalseBtn).click();
	}
	
	public void enterExplanationForTFQ()
	{
		driver.findElement(ExplanationTextBox).click();
		driver.findElement(ExplanationTextBox).sendKeys(prop.getProperty("TFExplanation"));
	}
	
	public void clickOnShortAnswerQuestion()
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(ShortAnswerQuestionBtn));
		System.out.println(ShortAnswerQuestionBtn.toString());
		driver.findElement(ShortAnswerQuestionBtn).click();
	}
	
	public boolean verifyQuestionView(String type)
	{
		WebElement questionView = null;
		switch(type) 
		{
		case "Short Answer" :
			questionView = driver.findElement(SAQuestionWindow);
			break;
			
		case "True False" :
			questionView = driver.findElement(TFQuestionWindow);
			break;
		case "Multiple Choice" :
			questionView = driver.findElement(MCQuestionWindow);
			break;
		default:
			System.out.println("Invalid Question Type View");
		}
		return questionView.isDisplayed();
	}
	
	public void enterSATypeQuestion()
	{
		driver.findElement(SAQToAsk).sendKeys(prop.getProperty("SAQuestion1"));
	}
	
	public void selectCorrectSAAnswer()
	{
		List<WebElement> correctAnswers = driver.findElements(SACorrectAnswers);
		correctAnswers.get(0).sendKeys(prop.getProperty("SAAnswer1"));
		correctAnswers.get(1).sendKeys(prop.getProperty("SAAnswer2"));
	}
	
	public void clickOnSaveAndExit()
	{
		wait.until(ExpectedConditions.elementToBeClickable(SaveAndExitBtn));
		driver.findElement(SaveAndExitBtn).click();
	}
	
	public boolean verifyQuizNameFromList()
	{
		String quizName = prop.getProperty("QuizName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+quizName+"']")));
		return driver.findElement(By.xpath("//a[text()='"+quizName+"']")).isDisplayed();
	}
}
