#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Socrative Login Feature

  @Smoke
  Scenario: Login to Socrative Page
    Given Teacher navigates to Socrative Login Page
    When Teacher enters Username and Password with Columns
      | Username          | Password  |
      | rajiv@showbie.com | 92cktaYV@ |
    And Teacher clicks on Sign In Button
    Then Teacher views the Socrative Home Page
