package com.pages;


import static com.sun.tools.javac.util.Assert.check;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.ConfigReader;

public class RoomPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	
	// Locators
	private By roomsTab = By.xpath(("//*[@id=\'header-nav\']/ul/li[3]"));
	private By roomTitle = By.cssSelector(".page-title");
	private By AddRoom = By.xpath("//button[text()='Add room']"); 
	private By addRoomWindow = By.xpath("//span[text()='Add Room']");
	private By roomName = By.id("roomName");
	private By addBtn = By.id("addRoomButton");
	private By cancelBtn = By.xpath("//button[text()='Cancel']");
	private By toolTip = By.cssSelector(".tooltip-text");
	private By roomNames = By.xpath("//*[@class='room-name']");
	
	//Contructor
	public RoomPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
	}

	//Action Methods
	public void clickRooms() {
		wait.until(ExpectedConditions.presenceOfElementLocated(roomsTab));
		driver.findElement(roomsTab).click();		
	}
	
	public String getRoomTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(roomTitle));
		return driver.findElement(roomTitle).getText();
	}
	
	public void clickAddRoom()
	{
		driver.findElement(AddRoom).click();
	}
	
	public void enterRoomName()
	{
		check(driver.findElement(addRoomWindow).isDisplayed());
		wait.until(ExpectedConditions.presenceOfElementLocated(roomName));
		driver.findElement(roomName).sendKeys(prop.getProperty("RoomName"));
	}
	
	public void clickOnAddBtn()
	{
		try {
		check(driver.findElement(addBtn).isDisplayed());
		check(driver.findElement(cancelBtn).isDisplayed());
		driver.findElement(addBtn).click();
		verifyToolMessage();
		
		}
		catch(Exception e)
		{
			verifyToolMessage();	
		}
		
	}
	
	public void verifyToolMessage()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(toolTip));
		if(driver.findElement(toolTip).isDisplayed())
		{
			check(driver.findElement(toolTip).getText().equals(prop.getProperty("ToolTipText")));		
			driver.findElement(roomName).clear();
			driver.findElement(roomName).sendKeys(prop.getProperty("RandomRoomName"));
			driver.findElement(addBtn).click();
		}
	}
	
	public boolean verifyRoomName() throws InterruptedException
	{
		String roomName = prop.getProperty("RandomRoomName");
		Thread.sleep(4000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> names = driver.findElements(roomNames);
		
		
//		names.forEach((rNames) -> {
//			if(rNames.getText().contains(prop.getProperty("RandomRoomName"))) 
//			
//				System.out.println("Room Name is Present");
//			
//			else System.out.println("Room Name is not present");
//				});
		
		List<String> list = new ArrayList<>();
		for(WebElement e : names)
		{
			list.add(e.getText());
		}
		
		System.out.println("List of Room Names: "+list);
		if(list.contains(roomName))
		return true;
		else 
			return false;
	    
	}
	

}
