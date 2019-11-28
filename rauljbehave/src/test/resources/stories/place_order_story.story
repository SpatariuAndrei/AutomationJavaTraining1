Meta:

Narrative:
As a user
I want to place and order
So that I can buy a specific product

Scenario: place an order on eMag
Given I open eMag home page
And I log in
And I search for Mouse
When I found first product
And I add it to my cart
When I navigate to my cart
Then check $product was added to cart
Given I press Continua
And I set the order details
When I pres Pasul Urmator
Then I verify that message Total Comanda has an amount of money

