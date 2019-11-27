Scenario: the scope of this scenario is to add a product in favorite list

Given I search for book
When I add the product to favorite
Then I should see product in favorite products
When I add a product to cart
When I click on cart details
When I delete the product from cart
Then I should receive a message

