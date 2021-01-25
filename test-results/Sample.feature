Feature: Login Feature


    Scenario: Teacher Logs into Socrative Application

        Given The Teacher visits the Socrative url for Login
        When The Teacher enters
            | email             | password  |
            | rajiv@showbie.com | 92cktaYV@ |

        And The Teacher clicks on Sign In Option
        Then The Teacher views the Socrative Home Page


    Scenario Outline: Teacher Creates a Room

        Given The Teacher is present in the Socrative Home Page
        When The Teacher clicks on Rooms Tab
            And The Teacher clicks on Add Room
        Then The Teacher views the Room Name popup

        When The Teacher enters the valid <Room name> and clicks on Add
        Then The Teacher views the 'Room Added' message on the Page

        When The Teacher clicks on the New Room Link
        Then The Teacher views the page navigating to Launch Tab
            And The Teacher views the <Room name> on the Home Page

        Examples:
            | Room name      |
            | SocrativeRoom1 |


