Feature: Account creation

Background: 
Given I am on the OpenCart login page

Scenario: Registration with new account
          When User click on continue
          Then User should be redirected to Register account page    
          When User enters Personal details
          And User click on continue button
          Then User should get account creation msg