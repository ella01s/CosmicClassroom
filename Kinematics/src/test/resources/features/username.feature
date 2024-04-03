Feature: As a user, i want to provide my username and have my username used to store helpful information about me
  Scenario Outline: User provides name that does not already exist in the database
    Given I start the program and am requested to provide a username
    When I provide a username "<username>" for the first time and it does not already exist in the program
    And I press enter
    Then my username will be added to the database
    Examples:
    |username|
    |elvis   |
    |mr.potato head|
    |sandii        |
