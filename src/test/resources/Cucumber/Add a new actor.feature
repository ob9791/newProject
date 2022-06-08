Feature: Add a new actor
  As a user I would Like to add a new actor into my table

  Scenario: I successfully add an actor to the table
    Given I have the actor info
    When I input the data into the database
    Then I get the success return string

  Scenario: I dont have enough info
    Given  I have actors first name
    And I dont have their last name
    When I try to add them into database
    Then I get an error message