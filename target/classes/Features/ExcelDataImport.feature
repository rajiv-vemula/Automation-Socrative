Feature: Data Driven Feature using Excel Sheet

  Scenario Outline: Create a Quiz
    When Teacher clicks on Quizzes Tab, Add Quiz and Create New
    Then Teacher views the default name and question types in the page
    When Teacher enters Quiz Name from "<Sheetname>" and rownumber <RowNumber>
    And Teacher clicks on Multiple Choice Question Type
    Then Teacher views the MC Type with all the default options

    Examples: 
      | SheetName     | RowNumber |
      | SocrativeData |         0 |
