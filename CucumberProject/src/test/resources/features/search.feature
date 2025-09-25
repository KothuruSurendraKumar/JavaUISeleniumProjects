@Search
Feature: Search Page
  I want to use this template for my feature file
  
 Background: 
  Given User navigates to login page
    When user enter the email "king.kohili@gmail.com"
    When user enters the password "King@123"
    And User clicks on Login button
    Then User should get successfully logged in
 

  Scenario: User searches for a valid product
Given User opens the Application
When User enters valid product "HP" into Search box field
And User clicks on Search button
Then User should get valid product displayed in search results

  