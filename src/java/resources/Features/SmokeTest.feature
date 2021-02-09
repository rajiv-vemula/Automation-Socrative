@Smoke
Feature: Smoke Test for Socrative Application

  Background: 
    Given Teacher navigates to Socrative Login Page
    When Teacher enters Username and Password
      | rajiv@showbie.com | 92cktaYV@ |
    Then Teacher views the "Reset password" and "Create account" Links
    
    When Teacher clicks on Sign In Button
    Then Teacher views the Socrative Home Page

  @Smoke @CreateRoom
  Scenario: Smoke Test
    #Create a Room
    #When Teacher clicks on Rooms Tab
    #Then Teacher views "Rooms" Page
    #
    #When Teacher clicks on Add Room
    #And Teacher enters the Room Name and clicks on Add
    #Then Teacher verifies Room Added Message and Room Name in the page
    #
    #When Teacher clicks on the Room Name and confirms the Popup
    #Then Teacher verifies the control is in the "Launch" Page
    #And Teacher verifies Room Name is displayed on the centre of page
    #
    #
    #Create a Quiz
    #When Teacher clicks on Quizzes Tab
    #Then Teacher views the "Quizzes" Page
    #
    #When Teacher clicks on Add Quiz and Create New
    #Then Teacher views the default name, toggles and question types in the page
    #
    #When Teacher enters the Quiz Name
    #And Teacher clicks on Multiple Choice Question Type
    #Then Teacher views the MC Type with all the default options
    #
    #When Teacher enters Multiple Choice Question
    #And Teacher enters the Options/Answers for the question
    #And Teacher chooses right answer and clicks on Save
    #Then Teacher views the Multiple Choice Question is Saved into Quiz
    #And Teacher views "Add a Question" text with Question Types
    #
    #
    #When Teacher clicks on True/False Question
    #Then Teacher views the TF Type with all the default options
    #When Teachers enters the True/False Question 
    #And Teacher selects the correct option 
    #And Teacher enters Explanation and clicks on Save
    #Then Teacher views the True/False Question is Added into Quiz 
    #
    #
    #When Teacher clicks on Short Answer Question
    #Then Teacher views the SA Type with all the default options
    #When Teacher enters the Short Answer Question
    #And Teacher enters the correct answers and clicks on Save
    #Then Teacher views the SA Question is saved into Quiz
    #
    #When Teacher clicks on Save and Exit Button to Save the Quiz
    #Then Teacher views the Quiz is saved in the top of the Quiz List in Quizzes Tab
    
    #Launch a Quiz
    When Teacher clicks on Launch Tab
    Then Teacher verifies the control is in the "Launch" Page
    
    When Teacher clicks on Quiz
    And Teacher selects the Quiz from the list and click on Next
    And Teacher enters the Delivery Method as "Instant Feedback" and Settings and click on Start
    Then Teacher verifies the control is in the "Results" Page
    And Teacher verifies the activity is "Active" from Results Page
    And Teacher views the QuizName, Show Names, Responses and Results Toggle in the page
    
    When Teacher clicks on Finish Button on results Page
    Then Teacher views the "Finish Activity?" Popup on the page
    
    When Teacher clicks on "Finish" Button in the Popup
    Then Teacher verifies the activity is "InActive" from Results Page
    And Teacher views the Toggles, Share and Export Button
    
    When Teacher clicks on the any question
    Then Teacher views the question with buttons for respective question types
    And Teacher views the navigate between question button
    
    When Teacher clicks on "Back To Results Table" button
    Then Teacher verifies the control is in the "Reports" Page
    
    #  TODO
    #Export and Share Functionalities
        
    
    #Launch an SA Quick Question by Live Activity
    When Teacher clicks on Results Tab
    And Teacher clicks on Launch Activity Button
    Then Teacher verifies the control is in the "Launch" Page
    
    When Teacher clicks on Short Answer from Quick Question Section
    Then Teacher verifies SA View with default options
    
    When Teacher enters the question under Optional Question Section
    And Teacher selects the toggles for Unlimited Responses and Student Names
    And Teacher clicks on Start Button
    Then Teacher verifies the control is in the "Results" Page
    And Teacher views the "Quick Question" text with current date and time
    And Teacher views the Start Vote, Show Answers, Show Names Buttons
    And Teacher verifies the activity is "Active" from Results Page
    # TODO --- Teacher verifies the student responses
    
		When Teacher clicks on Finish Button on results Page
    Then Teacher views the "Finish Activity?" Popup on the page
    
    When Teacher clicks on "Finish" Button in the Popup
    Then Teacher verifies the activity is "InActive" from Results Page
    
    #Launch a Space Race
    #Launch an Exit Ticket
    #Launch a MC,TF Quick Questions
    
    #Validate the Report
    #Retrieve and validate existing report
    
    #Logout from Application
    
    
    
    
    
    
