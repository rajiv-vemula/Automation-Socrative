package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.util.ConfigReader;
import com.util.ElementUtil;

import pojo.Teacher;
import pojo.Student;

public class RoomPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;
	private Teacher teacher;
	private Student student;
	
	// Locators
	private By roomsTab = By.xpath(("//span[text()='Rooms']"));
	private By roomTitle = By.cssSelector(".page-title");
	private By addRoom = By.xpath("//button[text()='Add room']"); 
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
	private By roomAddedMessage = By.xpath("//*[(text() = 'Room added!' or . = 'Room added')]");
	private By roomDeletedMessage = By.xpath("//*[(text() = 'Room deleted!' or . = 'Room deleted')]");
	
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
	
	
	public RoomPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		prop = ConfigReader.initProp();
		teacher = new Teacher();
		student = new Student();
	}

	public void clickRooms() {
		wait.until(ExpectedConditions.presenceOfElementLocated(roomsTab));
		driver.findElement(roomsTab).click();		
	}
	
	public String getRoomTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(roomTitle));
		return driver.findElement(roomTitle).getText();
	}
	
	public void clickAddRoom() {
		wait.until(ExpectedConditions.elementToBeClickable(addRoom));
		driver.findElement(addRoom).click();
	}
	
	public void enterRoomName() {
		Assert.assertTrue(driver.findElement(addRoomWindow).isDisplayed());
		wait.until(ExpectedConditions.presenceOfElementLocated(roomName));
		driver.findElement(roomName).sendKeys(prop.getProperty("RoomName"));
	}
	
	public void clickOnAddBtn() {
		try {
			Assert.assertTrue(driver.findElement(addBtn).isDisplayed());
			Assert.assertTrue(driver.findElement(cancelBtn).isDisplayed());
			driver.findElement(addBtn).click();
			verifyToolMessage();
		}
		catch(Exception e) {
			verifyToolMessage();	
		}
		
	}
	
	public void verifyToolMessage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(toolTip));
		if(driver.findElement(toolTip).isDisplayed())
		{
			Assert.assertTrue(driver.findElement(toolTip).getText().equals(prop.getProperty("ToolTipText")));		
			driver.findElement(roomName).clear();
			
			teacher.setRoomName(prop.getProperty("RandomRoomName"));
			driver.findElement(roomName).sendKeys(teacher.getRoomName());
			driver.findElement(addBtn).click();
		}
	}
	
	public boolean verifyRoomName() {
		teacher.setEnteredRoomName(By.xpath("//span[contains(text(),'"+teacher.getRoomName().toLowerCase()+"')]"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(teacher.getEnteredRoomName()));
		List<WebElement> names = driver.findElements(roomNames);
	
		List<String> list = new ArrayList<>();
		for(WebElement e : names)
		{
			list.add(e.getText());
		}
		
		System.out.println("List of Room Names: "+list);
		return list.contains(teacher.getRoomName().toUpperCase());
	}
	
	public boolean verifyMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(roomAddedMessage));
		return driver.findElement(roomAddedMessage).isDisplayed();
	}

	public void clickOnRoom() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(roomAddedMessage));
		driver.findElement(teacher.getEnteredRoomName()).click();
	}
	
	public void confirmPopUp() {
		String message = "Are you sure you want to change to the "+teacher.getRoomName().toUpperCase()+" room?";
		Assert.assertTrue(driver.findElement(popUpTitle).getText().equals("Please Confirm"));
		Assert.assertTrue(driver.findElement(popUpMessage).getText().equals(message));
		Assert.assertTrue(driver.findElement(popUpNoBtn).isDisplayed());
		driver.findElement(popUpYesBtn).click();
	}
	
	public boolean verifyHeaderRoomName() {
		return driver.findElement(teacher.getEnteredRoomName()).isDisplayed();
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
		
		student.setStudent1FirstName(prop.getProperty("student1FirstName"));
		student.setStudent1LastName(prop.getProperty("student1LastName"));
		student.setStudent1ID(prop.getProperty("student1ID"));
		student.setStudent1Email(prop.getProperty("student1Email"));
		
		driver.findElement(studentLastName).sendKeys(student.getStudent1LastName());
		driver.findElement(studentFirstName).sendKeys(student.getStudent1FirstName());
		driver.findElement(studentID).sendKeys(student.getStudent1ID());
		driver.findElement(studentemail).sendKeys(student.getStudent1Email());
	}

	public void clickOnButtonInForm(String button) {
		driver.findElement(ElementUtil.getPath(button)).click();
	}

	public boolean validateStudentDetailsInRoster() {
		By name = By.cssSelector("input[value='"+student.getStudent1LastName()+ ", "+student.getStudent1FirstName()+"']");
		By id = By.cssSelector("input[value='"+student.getStudent1ID()+"']");
		By email = By.cssSelector("input[value='"+student.getStudent1Email()+"']");
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(name));
		return driver.findElement(name).isDisplayed() && driver.findElement(id).isDisplayed() && driver.findElement(email).isDisplayed();
	}

}
