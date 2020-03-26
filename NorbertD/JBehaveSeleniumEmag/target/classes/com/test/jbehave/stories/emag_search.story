Narrative:

In order to show the search functionality
As a user
I want to search for a product

Scenario: Search for an existing product scaun

Given I am on home page emag
When I search for scaun
Then there are many products

Scenario: Search for an nonexisting product scaun something angel cloud

Given I am on home page emag
When I search for scaun something angel cloud
Then there are no products