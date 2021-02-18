package com.pages;


import static com.sun.tools.javac.util.Assert.check;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	private String RoomName;
	
	// Locators
	private By roomsTab = By.xpath(("//span[text()='Rooms']"));
	private By roomTitle = By.cssSelector(".page-title");
	private By AddRoom = By.xpath("//button[text()='Add room']"); 
	private By addRoomWindow = By.xpath("//span[text()='Add Room']");
	private By roomName = By.id("roomName");
	private By addBtn = By.id("addRoomButton");
	private By cancelBtn = By.xpath("//button[text()='Cancel']");
	private By toolTip = By.cssSelector(".tooltip-text");
	private By roomNames = By.xpath("//*[@class='room-name']");
	private By popUpTitle = By.cssSelector(".popup-title");
	private By popUpMessage = By.id("pop-up-message");
	private By popUpYesBtn = By.xpath("//button[text()='Yes']");
	private By popUpNoBtn = By.xpath("//button[text()='No']");
	
	//Contructor
	public RoomPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.init_prop();
		RoomName = null;
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
		RoomName = prop.getProperty("RandomRoomName").toUpperCase();
		By EnteredRoomName = By.xpath("//span[contains(text(),'"+RoomName.toLowerCase()+"')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(EnteredRoomName));
		List<WebElement> names = driver.findElements(roomNames);
	
		List<String> list = new ArrayList<>();
		for(WebElement e : names)
		{
			list.add(e.getText());
		}
		
		System.out.println("List of Room Names: "+list);
		if(list.contains(RoomName)) {
			return true;
		}
		else 
			return false;
	}
	

	public void clickOnRoom()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='"+RoomName.toLowerCase()+"']")).click();;
	}
	
	public void confirmPopUp()
	{
		String message = "Are you sure you want to change to the "+RoomName+" room?";
		check(driver.findElement(popUpTitle).getText().equals("Please Confirm"));
		check(driver.findElement(popUpMessage).getText().equals(message));
		check(driver.findElement(popUpNoBtn).isDisplayed());
		driver.findElement(popUpYesBtn).click();
	}
	
	public boolean verifyHeaderRoomName()
	{
		return driver.findElement(By.xpath("//span[text() = '"+RoomName.toLowerCase()+"']")).isDisplayed();
	}
}
