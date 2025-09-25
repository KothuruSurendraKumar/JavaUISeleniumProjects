
Feature: Login Functionality
  
  @Login
  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in

    Examples: 
      | username | password |
      | suri.kumar@gmail.com |     Suri@123 | 
      | king.kohil@gmail.com |     King@123 |

  @InvalidCredentials
  Scenario: Login with invalid valid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "password" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
    
    Scenario: Login with valid email and invalid passoword
    Given User navigates to login page
    When User enters valid email address "suri.kumar@gmail.com" into email field
    And User enters invalid password "1234567" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
    
    Scenario: Login with invalid email and valid passoword
    Given User navigates to login page
    When User enters valid email address "suri.kumarking@gmail.com" into email field
    And User enters invalid password "Suri@123" in password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
    
    Scenario: Login with empty email and empty passoword
    Given User navigates to login page
    When User do not enter valid email address into email field
    And User do not enters valid password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials invalid
    
    
    
    
    