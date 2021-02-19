package com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	private WebDriverWait wait ;
	
	private By controlTab = By.cssSelector(".selected span");
	
	public ElementUtil(WebDriver driver)
	{
		System.out.println("Element Util Contructor");
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public boolean verifyControlOnTab(String page)
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(controlTab)); 
		System.out.println(driver.findElement(controlTab).getText());
		return driver.findElement(controlTab).getText().equals(page.toUpperCase());
	}
	
	public boolean verifyDateAndTime() {
		LocalDateTime localTime = LocalDateTime.now();   
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy, h:");  	
		String timestamp = localTime.format(formatter);
	   
		System.out.println("Local Time is: "+timestamp);
		
	    return driver.findElement(By.xpath("//time[contains(text(),'"+timestamp+"')]")).isDisplayed();     
	}

}
