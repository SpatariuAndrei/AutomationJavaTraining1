Scenario: I want to make an order

Given I search for fard
When I add a product to cart
And I click on product details
And I press on Continua
And I select Livrare prin curier
And I select Ramburs la curier
And I click on Pasul urmator
Then I should see Trimie comanda button
