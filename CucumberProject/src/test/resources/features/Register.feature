@Register
Feature: User Regestration
  I want to use this template for my feature file

  //@tag1
  Scenario: Register with valid and mandetory fields
    Given user navigates to register account page
    When user enters all mandetory fields
    |firstname | Mouni |
    |password  | Mouni@123   | 
    |telephone | 1234567890 |
    |lastname  | reddy |
    And user click privacy policy
    And user clicks continue button
    Then user registers succesfully
    
    @Register1
    Scenario: Register with valid and all fields
    Given user navigates to register account page
    When user enters all mandetory fields
    |firstname | Sandhya |
    |password  | Sandy   | 
    |telephone | 1234567890 |
    |lastname  | rani |
    And user clicks newsstaller checkbox
    And user click privacy policy
    And user clicks continue button
    Then user registers succesfully
    
    @Register2
    Scenario: User register with dupicate account
    Given user navigates to register account page
    When user enters all mandetory fields with duplicate email
    |firstname | Sandhya |
    |email     | king.kohil@gmail.com |
    |password  | Sandy   | 
    |telephone | 1234567890 |
    |lastname  | rani |
    And user clicks newsstaller checkbox
    And user click privacy policy
    And user clicks continue button
    Then user need to get respective warning message
    
    @Register3
    Scenario: User doesnt enters any field
    Given user navigates to register account page
    When user donot enter any field
    And user clicks continue button
    Then user need to get respective warning messages for every field
    
    