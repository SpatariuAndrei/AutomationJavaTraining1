Meta:

Narrative:
As a user
I want to seach after a product
So that I can buy it

Scenario: buy a product form eMag
Given I open eMag home page
And I log in
And I search for brad
When I found first brad with discount badge
And I add it to my cart
When I navigate to my cart
Then my cart should not be empty


