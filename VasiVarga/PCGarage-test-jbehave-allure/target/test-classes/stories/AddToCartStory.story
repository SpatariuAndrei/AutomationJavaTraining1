!-- Narrative:
!-- As a user
!-- I want to search for a product on pcgarage.ro and I want to add it to my shopping cart
!-- So I can buy it later
Meta:

Scenario: Search for the specific product from the homepage and add it to my cart
Given I go to PCGarage home page
When I search for <product>
When I go to the <productName> page
When I add it to my cart
Then I can see the <cartProductName> in my cart

Examples:
|product|productName|cartProductName|
|JBL Flip 5|Boxa portabila JBL Flip 5 Blue|Boxa portabila JBL Flip 5 Blue|