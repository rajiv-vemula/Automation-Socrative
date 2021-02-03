package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
    private WebDriverWait wait;
	
	// 1. By Locators
    private By emaildId = By.name("email");
    private By password = By.name("password");
	private By signInButton = By.id("teacherLoginButton");
	private By headerName = By.cssSelector("#header-room-name");
	private By userName = By.cssSelector("#header-user-name span");
	
	// 2.Contructor of the Page
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	//3. Page Actions: Features of the page the form of methods
	
	public boolean verifyLinks(String ResetPwd, String CreateAcct)
	{
		if(driver.findElement(By.linkText(ResetPwd)).isDisplayed() && driver.findElement(By.linkText(CreateAcct)).isDisplayed())
		{
			return true; 
		}
		else
			return false;
	}
	
	public void enterEmail(String email)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(emaildId));
		driver.findElement(emaildId).sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnSignIn()
	{
		driver.findElement(signInButton).click();
	}
	
	public boolean verifyLogin()
	{	
		wait.until(ExpectedConditions.visibilityOfElementLocated(headerName));
		String name = driver.findElement(userName).getText();
		if(driver.findElement(headerName).isDisplayed() && name.equals("Rajiv"))
		{
			return true;
		}	
		else 
			return false;
	}

}
