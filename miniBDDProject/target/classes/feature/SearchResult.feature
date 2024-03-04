Feature: Search for product

Scenario: Search and add product to cart
Given User is on Index page
When User searches for product in search box
Then User should see product 
When User click on the product
Then User should be redirected to product specification page
And User selects the quantity
When User click on Add to cart
Then User should see a product added msg
