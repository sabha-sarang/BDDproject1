Feature: HomePage 

Background: 
Given I am on the OpenCart login page

Scenario: Verifying Homepage details
Given I have entered a valid username and password    
When I click on the login button
Then I should be logged in successfully
Given User is on Homepage
When User clicks on Edit Account 
Then User should be redirected to edit account page
When User makes changes in field 
And click on continue
Then User should see a success msg
And User should be able to see Wish List in section menu
And User should be able to see Order History in section menu
When User click on password
Then User should be redirected to change password page
When click on Home icon
Then User should be back to index page