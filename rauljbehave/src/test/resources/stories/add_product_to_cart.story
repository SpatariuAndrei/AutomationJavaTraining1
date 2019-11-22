Meta:

Narrative:
As a user
I want to seach after a product
So that I can buy it

Scenario: buy a product form eMag
Given start page on emag
And I log in
And I search for brad
When I found first brad with discount badge
Then I add it to my cart
When I navigate to my cart
Then my cart should not be empty


