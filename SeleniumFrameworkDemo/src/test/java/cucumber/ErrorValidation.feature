
Feature: Checking Credentials in Login Page
  I want to use this template for my feature file

  
  @ErrorValidation
  Scenario Outline: Negetive testcase for Login Page
  	Given I landed on Ecommerce Page
  	When Login with user <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name         | password  |
      | kumar@don.com| Kumar@12  |
