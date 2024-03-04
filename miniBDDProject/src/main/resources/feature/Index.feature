Feature: Index page

Scenario: Verfying the Components of Index page
Given User is on Index page
When User searches for product in search box
Then User should see product
And User should be able to see Logo
When User click on My Account
And User click on Login
Then Login Page should be displayed

