

Feature: Naukari Login Application
 

  @Login
  Scenario: Login with valid credentials
    Given land on naukari page
    When I enter username "kothurusurendra98@gmail.com" and password "Surendra@1"
    And click the login button
    Then user should land on homepage
    
    @InvalidLogin
  Scenario: Login with valid credentials
    Given land on naukari page
    When I enter username <username> and password <password>
    And click the login button
    Then verify <status> message based on credentials entered
    
    Examples:
    | username  | password | status |
    | abcdefgh  | good@abc   | Invalid details. Please check the Email ID - Password combination. |
    | snnnsjnjs  | welcome@acv  | Invalid details. Please check the Email ID - Password combination. |

  