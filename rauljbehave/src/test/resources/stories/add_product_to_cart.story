Meta:

Narrative:
As a user
I want to seach after a product
So that I can add it to my cart

Scenario: add a product to my cart
Given I open eMag home page
And I log in
And I search for Brad
When I found first brad with discount badge
And I add it to my cart
When I navigate to my cart
Then check Brad was added to cart


