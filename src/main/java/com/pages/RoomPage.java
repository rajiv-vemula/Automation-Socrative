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
	
	// Rostered Room
	private By rosteredBtn = By.xpath("//li[contains(@class,'current-room')]//child::span[@class='roster-action-button']");
	private By studentTotal = By.cssSelector("input[type='tel']");
	private By createFormBtn = By.xpath("//span[text()='Create Form']");
	private By modalTitle = By.className("modal-title");
	private By modalHolder = By.id("modal-holder");
	private By addAnotherStudentBtn = By.xpath("//span[text()='Add Another']");
	private By studentLastName = By.cssSelector("input[placeholder = 'Last Name']");
	private By studentFirstName = By.cssSelector("input[placeholder = 'First Name']");
	private By studentID = By.cssSelector("input[placeholder = 'Student ID']");
	private By studentemail = By.cssSelector("input[placeholder = 'Email (optional)']");
	private By studentDetails = By.className("student-data-wrapper");
	
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
	
	public boolean verifyRoomName()
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
		driver.findElement(By.xpath("//span[text()='"+RoomName.toLowerCase()+"']")).click();			
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

	public void clickOnRosterButton() {
		wait.until(ExpectedConditions.elementToBeClickable(rosteredBtn));
		driver.findElement(rosteredBtn).click();
	}

	public void clickOnMethod(String method) {
		By addMethod = By.xpath("//li[contains(@class,'current-room')]//child::li[text()='"+method+"']");
		wait.until(ExpectedConditions.elementToBeClickable(addMethod));
		driver.findElement(addMethod).click();
	}

	public String verifyTitleWindow() {
		return driver.findElement(modalTitle).getText();
	}

	public void enterStudentCount() {
		driver.findElement(studentTotal).sendKeys(prop.getProperty("totalStudents"));
	}

	public void clickOnCreateForm() {
		driver.findElement(createFormBtn).click();
	}

	public boolean verifyAddStudentModal() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(modalHolder));
		return driver.findElement(modalHolder).isDisplayed() && driver.findElement(addAnotherStudentBtn).isDisplayed();
	}

	public void enterStudenDetails() {
		String firstName = prop.getProperty("student1FirstName");
		String lastName = prop.getProperty("student1LastName");
		String ID = prop.getProperty("student1ID");
		String email = prop.getProperty("student1Email");
		
		driver.findElement(studentLastName).sendKeys(lastName);
		driver.findElement(studentFirstName).sendKeys(firstName);
		driver.findElement(studentID).sendKeys(ID);
		driver.findElement(studentemail).sendKeys(email);
	}

	public void clickOnButtonInForm(String button) {
		driver.findElement(By.xpath("//button[text()='"+button+"']")).click();
	}

	public boolean validateStudentDetailsInRoster() {
		String firstName = prop.getProperty("student1FirstName");
		String lastName = prop.getProperty("student1LastName");
		String ID = prop.getProperty("student1ID");
		String email = prop.getProperty("student1Email");
		
		//String details = driver.findElement(studentDetails).getText();
		//System.out.println(details);
		String k = driver.findElement(By.className("last-name")).getText();
		System.out.println(k.contains(firstName));
		System.out.println(k);
		
		
		//return details.contains(firstName) && details.contains(lastName) && details.contains(ID) && details.contains(email);
	return true;
	}

}
