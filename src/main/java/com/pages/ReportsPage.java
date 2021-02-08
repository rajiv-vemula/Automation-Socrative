package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.ConfigReader;

public class ReportsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	
	
	public ReportsPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}
}
