Feature: Smoke Test for Socrative Application

  Background: 
    Given Teacher navigates to Socrative Login Page
    Then Teacher views the default Socrative Login Page
    And Teacher views the "Reset password" and "Create account" Links
    
  @Smoke
  Scenario: Smoke Test for Socrative
  	
  	#Login to Socrative as Teacher
  	When Teacher enters Email and Password
      | rajiv@showbie.com | 92cktaYV@ |
      
    And Teacher clicks on Sign In Button
    Then Teacher views the Socrative Home Page
    
    #Create a Non-Rostered Room
    When Teacher clicks on Rooms Tab
    Then Teacher views "Rooms" Page
    
    When Teacher clicks on Add Room
    And Teacher enters the Room Name and clicks on Add
    Then Teacher verifies Room Added Message and Room Name in the page
    
    When Teacher clicks on the Room Name and confirms the Popup
    Then Teacher verifies the control is in the "Launch" Page
    And Teacher verifies Room Name is displayed on the centre of page   
    
    #Create a Quiz
    When Teacher clicks on Quizzes Tab
    Then Teacher views the "Quizzes" Page
    
    When Teacher clicks on Add Quiz and Create New
    Then Teacher views the default name, toggles and question types in the page
    
    When Teacher enters the Quiz Name
    And Teacher clicks on Multiple Choice Question Type
    Then Teacher views the MC Type with all the default options
    
    When Teacher enters Multiple Choice Question
    And Teacher enters the Options/Answers for the question
    And Teacher chooses right answer for MC Question
    And Teacher clicks on Save Question button
    Then Teacher views the Multiple Choice Question is Saved into Quiz
    And Teacher views "Add a Question" text with Question Types  
    
    When Teacher clicks on True/False Question
    Then Teacher views the TF Type with all the default options
    When Teachers enters the True/False Question 
    And Teacher selects the correct option 
    And Teacher enters the Explanation for the TF Question
    And Teacher clicks on Save Question button
    Then Teacher views the True/False Question is Added into Quiz 
        
    When Teacher clicks on Short Answer Question
    Then Teacher views the SA Type with all the default options
    When Teacher enters the Short Answer Question
    And Teacher enters the correct answers for SA Question
    And Teacher clicks on Save Question button
    Then Teacher views the SA Question is saved into Quiz
    
    When Teacher clicks on Save and Exit Button to Save the Quiz
    Then Teacher views the Quiz is saved in the top of the Quiz List in Quizzes Tab
    
    #Launch a Quiz
    When Teacher clicks on Launch Tab
    Then Teacher verifies the control is in the "Launch" Page
    
    When Teacher clicks on Quiz
    And Teacher selects the Quiz from the list and click on Next
    And Teacher enters the Delivery Method as "Instant Feedback" and Settings 
    And Teacher click on Start Button to Launch a quiz
    Then Teacher verifies the control is in the "Results" Page
    And Teacher verifies the activity is "Active" from Results Page
    And Teacher views the QuizName, Show Names, Responses and Results Toggle in the page
    
    When Teacher clicks on Finish Button on results Page
    Then Teacher views the "Finish Activity?" Popup on the page
    
    When Teacher clicks on "Finish" Button in the Popup
    Then Teacher verifies the activity is "InActive" from Results Page
    And Teacher views the Toggles, Share and Export Button
    And Teacher verifies the date and time of the Report in the page
    
    When Teacher clicks on the 1st question from Results Grid
    Then Teacher views the question with buttons for respective question types
    
    When Teacher navigates between questions
    And Teacher clicks on "Back to Results Table" button on Reports Page
    Then Teacher verifies the control is in the "Reports" Page
         
    #Launch an SA Quick Question by Live Activity
    When Teacher clicks on Results Tab
    And Teacher clicks on Launch Activity Button
    Then Teacher verifies the control is in the "Launch" Page
    
    When Teacher clicks on Short Answer from Quick Question Section
    Then Teacher verifies SA View with default options
    
    When Teacher enters the question under Optional Question Section
    And Teacher selects the toggles for "Allow unlimited responses" and "Require student names"
    And Teacher clicks on Start Button in the SA Box
    Then Teacher verifies the control is in the "Results" Page
    And Teacher views the "Quick Question" text with current date and time
    And Teacher views the "Start Vote", "Show Answers", "Show Names" Buttons
    And Teacher verifies the activity is "Active" from Results Page
    
		When Teacher clicks on Finish Button on results Page
    Then Teacher views the "Finish Activity?" Popup on the page
    
    When Teacher clicks on "Finish" Button in the Popup
    Then Teacher verifies the activity is "InActive" from Results Page  
    
    #Launch a Space Race
    When Teacher clicks on Launch Tab
    Then Teacher verifies the control is in the "Launch" Page
    
    When Teacher clicks on Space Race
    And Teacher selects the Quiz from the list and click on Next
    And Teacher choose the Space Race Settings with teams
    And Teacher click on Start Button to Launch a quiz
    Then Teacher verifies the control is in the "Results" Page  
    And Teacher verifies "Space Race" is launched with name and selected number of teams
    And Teacher verifies the activity is "Active" from Results Page
    
    When Teacher clicks on Finish Button on results Page
    And Teacher clicks on OK to Confirm the Popup
    Then Teacher verifies the control is in the "Reports" Page
    And Teacher verifies the activity is "InActive" from Results Page
    And Teacher views the Toggles, Share and Export Button
    
     #Adding students into a Room
    When Teacher clicks on Rooms Tab
    Then Teacher verifies the control is in the "Rooms" Page
    
    When Teacher clicks on Roster button to add students
    And Teacher clicks on "Manual (Type In)" method to enter the students
    Then Teacher views "Add Students" title window to select number of students
    
    When Teacher enters the number of students to add
    And Teacher clicks on Create Form button
    Then Teacher views the modal with default options
    
    When Teacher enters the student details - firstname, lastname, ID, email
    And Teacher clicks on "Save" button in the form
    Then Teacher validates the student details in the Roster
    
     #Launch a Quiz in a Rostered Room
    When Teacher clicks on Launch Tab
    Then Teacher verifies the control is in the "Launch" Page
    
    When Teacher clicks on Quiz
    And Teacher selects the Quiz from the list and click on Next
    And Teacher enters the Delivery Method as "Instant Feedback" and Settings 
    And Teacher click on Start Button to Launch a quiz
    Then Teacher verifies the control is in the "Results" Page
    And Teacher verifies the activity is "Active" from Results Page
    And Teacher views the QuizName, Show Names, Responses and Results Toggle in the page
    
    # Get Student Responses
    When Student navigates to Socrative Login Page
    Then Student views "Student Login" Window in the page
    
    When Student enters the Room Name and click on Join
    And Student enters the Student ID and clicks on Submit
    Then Student views the Room Name and Last Name in the page
    
    When Student answers the first question in the quiz
    And Student clicks on Submit Button
    Then Student views the Feedback Container with Question, Correct Answer and Explanation
   
    When Student clicks on OK in the Feedback Box
    And Student answers the second question in the quiz
    And Student clicks on Submit Button
    Then Student views the Feedback Container with Question, Correct Answer and Explanation
   
    When Student clicks on OK in the Feedback Box
    And Student answers the third question in the quiz
    And Student clicks on Submit Button
    Then Student views the Feedback Container with Question, Correct Answer and Explanation
   
    When Student clicks on OK in the Feedback Box
    Then Student views the Activity Completed text in the page   
    
    #Logout from Student Application
    When Student clicks on header user name
    And Student clicks on "LOG OUT" button
    Then Student verifies the "Please Confirm" popup to Signout of application
    
    When Student clicks on Yes in the popup
    Then Student views "Student Login" Window in the page
    And Student closes the browser
    
    #Validating Student Responses
    Then Teacher validates the Student Responses
    When Teacher clicks on Finish Button on results Page
    Then Teacher views the "Finish Activity?" Popup on the page
    
    When Teacher clicks on "Finish" Button in the Popup
    Then Teacher verifies the activity is "InActive" from Results Page 
    
    
    #Logout from Teacher Application
    #When Teacher clicks on Header username on top right corner
    #And Teacher clicks on Sign Out Button
    #Then Teacher verifies the "Please Confirm" popup to Signout of application
    #
    #When Teacher clicks on Yes in the Popup
    #Then Teacher views the default Socrative Login Page   
    
    #TODO
    #Retrieve and validate an existing report from Reports Page
    
    #Verify the Teacher Account Profile
    
    #Export and Share Functionalities
    #MC,TF, Exit Ticket
    #Add Students in Roster by Excel
    #Download and validate Reports Excel,PDF
    #Email Students
    #Students #,% and Progress
    
    
