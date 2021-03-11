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
	
	public ElementUtil(WebDriver driver) {
		System.out.println("Element Util Contructor");
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public boolean verifyControlOnTab(String page) throws InterruptedException {
		Thread.sleep(1000);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(controlTab)); 
		System.out.println(driver.findElement(controlTab).getText());
		
		return driver.findElement(controlTab).getText().equalsIgnoreCase(page);
	}
	
	public boolean verifyDateAndTime() {
		LocalDateTime localTime = LocalDateTime.now();   
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, h:");  
	   
		System.out.println("Local Time is: " + localTime.format(formatter));
		
		By timeOfReport = By.xpath("//time[contains(text(),'"+localTime.format(formatter)+"')]");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(timeOfReport));
	    return driver.findElement(timeOfReport).isDisplayed();     
	}

	public static By getPath(String ele) {
		return By.xpath("//*[text()='"+ele+"']");
	}
	
	public static By getliElementFromList(String ele) {
		return By.xpath("//span[text()='"+ele+"']/parent::li");
	}
}
