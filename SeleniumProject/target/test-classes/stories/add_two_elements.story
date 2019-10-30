Scenario: check sum of two products in cart: one reduced and one normal
Given start page on eMAG
And I search for samsung
And I found the first normal product
And I store the normal product details in a Product object
And I add normal product to the cart
And I navigate back in browser
And I select the first reduced product
And I store the reduced product details in a Product object
And I add reduced product to the cart
And I go to view the cart
And I add the two prices in a float
And I store the cart total price in a float
When I compare the two floats
Then the two numbers must be equals