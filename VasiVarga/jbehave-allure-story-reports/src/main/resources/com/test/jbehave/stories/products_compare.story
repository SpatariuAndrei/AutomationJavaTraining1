Narrative:
As a user
I want to search for a product on pcgarage.ro
So I can pick an item

Scenario: Search for the specific product from the homepage
Given I go to PCGarage <homePage>
When I search for <productName>
Then I verify if the products are displayed

Examples:
|homePage|productName|
|https://www.pcgarage.ro/|JBL Flip 5|