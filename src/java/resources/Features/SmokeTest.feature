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
  Scenario Outline: Smoke Test
    #Create a Room
    When Teacher clicks on Rooms Tab
    Then Teacher views the "Rooms" Page
    When Teacher clicks on Add Room
    And Teacher enters the Room Name and clicks on Add
    Then Teacher verifies Room Added Message and Room Name in the page
    When Teacher clicks on the Room Name and confirms the Popup
    Then Teacher verifies the page is in Launch Tab and Room Name is displayed on the centre of page
    #Create a Quiz
    When Teacher clicks on Quizzes Tab, Add Quiz and Create New
    Then Teacher views the default name and question types in the page
    When Teacher enters the "<Quiz Name>"
    And Teacher clicks on Multiple Choice Question Type
    Then Teacher views the MC Type with all the default options

    Examples: 
       | Quiz Name            |
       | Socrative Automation |
