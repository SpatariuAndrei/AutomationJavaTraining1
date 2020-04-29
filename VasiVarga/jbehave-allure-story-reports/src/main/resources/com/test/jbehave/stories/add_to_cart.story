Narrative:
As a user
I want to search for a product on pcgarage.ro and I want to add it to my shopping cart
So I can buy it later

Scenario: Searching for a specific product from the homepage and adding it to my cart
Given I go to PCGarage <homePage>
When I search for <product>
When I go to the <productName> page
When I add it to my cart
Then I can see the <cartProductName> in my cart

Examples:
|homePage|product|productName|cartProductName|
|https://www.pcgarage.ro/|JBL Flip 5|Boxa portabila JBL Flip 5 Blue|Boxa portabila JBL Flip 5 Blue|