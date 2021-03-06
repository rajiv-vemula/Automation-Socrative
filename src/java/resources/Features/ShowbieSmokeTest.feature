Feature: Smoke Test for Showbie Application

  Background: 
    Given Teacher navigates to Showbie Login Page
    Then Teacher views the default Showbie "Sign In" Page
    
  @Smoke
  Scenario: Smoke Test for Showbie
  	
  	#Login to Socrative as Teacher
  	When Teacher enters Showbie username and Password
      | rajiv+qa@showbie.com | 92cktaYV@ |
      
    And Teacher clicks on Sign In Button in Showbie
    Then Teacher views the Showbie Home Page with "My Showbie" text
    
    #Create a Class
    When Teacher clicks on Wrench Button
    And Teacher clicks on New Class Button
    Then Teacher views "New Class" Window with default options
    
    When Teacher enters the Class Name in New Class field
    And Teacher clicks on Save button
    Then Teacher views the Class is added with the name
    And Techer views "add an assignment" guide tip in the page
    
    #Create a assignment
    When Teacher clicks on Wrench Button
    And Teacher clicks on New Assignment button
    Then Teacher New Assignment Window is opened with default options
    
    When Teacher enters the Assignment name in the Title
    And Teacher selects the DueDate, Student Access and Schedule
    And Teacher clicks on Save button
    Then Techer views "press to view folders" guide tip in the page
    And Teacher views the Assignment with selected settings is displayed in the page under Assigned
    
    When Teacher clicks on the Assignment Name
    Then Teacher views the Assignment Name and "Shared Items" folder
    
    When Teacher clicks on Shared Items folder
    Then Teacher verifies "Shared Items" page with "Write a comment..." textarea
    
    #Write a post
    When Teacher enters the post in the comment textarea
    And Teacher clicks on Post button
    Then Teacher validates the post is displayed in the post container
    
    #Post a New Document
    When Teacher clicks on + button
    And Teacher clicks on New Document button
    Then Teacher verifies New Document Window is opened with default settings
    
    When Teacher enters the Document Name, Orientation and Style
    And Teacher clicks on Create button
    Then Teacher validates the document is posted in the Post container
    
    
    