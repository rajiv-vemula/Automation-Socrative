Feature: CreateAccount and change it to PRO

As a Teacher create a free Socrative Account and change it to PRO in Profile Section

  Background: 
    Given Teacher navigates to Socrative Login Page
    Then Teacher views the default Socrative Login Page
    And Teacher views the "Reset password" and "Create account" Links
    
  @Smoke
  Scenario: Creating a free account and upgrading to PRO
  
  	#Create an account
  	When Teacher clicks on "Create account" link
  	Then Teacher views "New Teacher Account" page
  	
  	When Teacher enters the signUp details - "FirstName", "LastName", "Email" and "Password"
  	And Teacher clicks on Next button on Signup Page
  	Then Teacher views the "Demographics" Page on SignUp
  	
  	When Teacher enters the Demographics and accepts the Terms and Pvt Policy
  	And Teacher clicks on Next button on Signup Page
  	Then Teacher views the "Account Type" Page on SignUp
  	
  	When Teacher clicks on Socrative Free Account
  	And Teacher clicks on Finish Button for Registration
  	Then Teacher views the "Welcome to Socrative!" popup title
  	
  	When Teacher clicks on OK button in the Popup
  	Then Teacher views the Socrative Home Page
  	
  	# Change Teacher Account to PRO
  	When Teacher clicks on Header username on top right corner
  	And Teacher clicks on Profile Button
  	And Teacher clicks on Account Link on Profile
  	And Teacher clicks on Upgrade PRO Button on the page
  	Then Teacher views the default options for Seats and years as 1
  	
  	When Teacher selects seats, years and coupon code if available
  	Then Teacher validates the Total Amount with $99.99 per seat
  	
  	When Teacher clicks on Review and Pay button
  	Then Teacher views the "Payment Information" page
  	
  	When Teacher enters the card details - Card Name, Card Number, Expiry Date, CVC
  	And Teacher clicks on Purchase button
  	Then Teacher views "Payment Complete!" message on the page
  	And Teacher validates the details - name, email, license key, order number, order total
  	And Teacher views the Account is changed to Pro Account
  	
  	#Delete the Account
  	When Teacher clicks on "DELETE ACCOUNT" button
  	Then Teacher verifies the "Delete Account" popup on the page
  	
  	When Teacher enters the password in the field
  	And Teacher clicks on "Delete Account" button
  	