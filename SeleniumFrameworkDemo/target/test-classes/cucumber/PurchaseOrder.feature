@tag
Feature: Purchasing the order from Ecommerce Application
  
  
  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test for Submitting the order 
    Given Login with user <name> and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed in Confirmation Page

    Examples: 
      | name         | password  | productName      |
      | kumar@don.com| Kumar@123 | IPHONE 13 PRO    |
      
