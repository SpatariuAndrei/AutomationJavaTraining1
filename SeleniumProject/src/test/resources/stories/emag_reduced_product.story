Scenario: check reduced product price in cart

Given start page on eMAG
And I search for aer conditionat
And I found the first reduced product
And I store the details in a Product object
And I add it to the cart
And I go to view the cart
And I store the product from the cart in another Product object
When I compare the prices of Product objects
Then the two prices must be equals