package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;
import com.util.ConfigReader;

public class LaunchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	
	private By launchTab = By.cssSelector(("#header-nav ul li:nth-child(1)"));
	private By QuizBtn = By.xpath("//span[text() = 'Quiz']");
	private By SpaceRaceBtn = By.xpath("//span[text() = 'Space Race']");
	private By ExitTicketBtn = By.xpath("//span[text() = 'Exit Ticket']");
	private By MCBtn = By.xpath("//span[text() = 'Multiple Choice']");
	private By TFBtn = By.xpath("//span[text() = 'True / False']");
	private By SABtn = By.xpath("//span[text() = 'Short Answer']");
	
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
	
	
	public LaunchPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}
	
	public void verifyLaunchPage()
	{
		Assert.check(driver.findElement(launchTab).isDisplayed());
		
	      //identify parent element with ./.. expression in xpath
	     // WebElement parent = driver.findElement(launchTab).findElement(By.xpath("./.."));
	      
		String verify = driver.findElement(launchTab).getAttribute("class");
		System.out.println("Class"+verify);
	      //Assert.check(verify.equals("selected"));
	}
}
