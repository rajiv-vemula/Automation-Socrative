package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.ConfigReader;

public class StudentPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	private By studentRoomName = By.id("studentRoomName");
	
	public StudentPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}
}
