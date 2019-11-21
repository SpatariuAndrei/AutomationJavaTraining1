
Scenario: the scope of this scenario is to add a product in favorite list

Given I'm logged in as Coroama Loredana
When I search for iphone
When I add the product to favorite
Then I should see product in favorite products
