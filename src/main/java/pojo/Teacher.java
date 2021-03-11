package pojo;

import org.openqa.selenium.By;

import lombok.Data;


@Data public class Teacher {
	private String className;
	private String assignmentName;
	private int noOfTeams;
	private String roomName;
	private String quizName;
	private String classCode;
	private String dueDate;
	private String dueTime;
	private String studentAccess;
	private String comment;
	private By enteredRoomName;
	
	//SignUpPage
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	//Demographics
	private String country;
	private String orgName;
	private String orgType;
	private String orgRole;
	
	// NonPro to Pro
	private int seats;
	private int years;
	private String couponCode;
	
	//Card Information
	private String cardName;
	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private int cvc;
	
	// Payment Complete Validation
	private String licenseKey;
	private double orderTotal;
	private String orderNumber;
}
