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
  	
  	When Teacher enters the signUp details
  	And Teacher clicks on Next
  	Then Teacher views the Demographics Page
  	
  	When Teacher enters the Demographics and accepts the Terms & Conditions
  	And Teacher clicks on Next
  	Then Teacher views the Account Type Page to select the type
  	
  	When Teacher clicks on Socrative Free Account
  	And Teacher clicks on Finish Button for Registration
  	Then Teacher views the "Welcome to Socrative!" popup title
  	
  	When Teacher clicks on OK button
  	Then Teacher views the Socrative Home Page
  	
  	# Change Teacher Account to PRO
  	When Teacher clicks on Header username on top right corner
  	And Teacher clicks on Profile Button
  	And Teacher clicks on Account Link and Upgrade PRO Button
  	And Teacher selects seats, years and enters coupon code and apply
  	And Teacher clicks on Review and Pay button
  	Then Teacher views the "Payment Information" page
  	
  	When Teacher enters the card details and clicks on Purchase
  	Then Teacher views the Account is changed to Pro Account