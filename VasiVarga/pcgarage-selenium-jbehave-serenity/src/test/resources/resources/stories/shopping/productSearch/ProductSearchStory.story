Narrative:
As a user
I want to search for a product on pcgarage.ro
So I can pick an item

Scenario: Search for the specific product from the homepage
Given I go to PCGarage home page
When I search for <productName>
Then I verify if products are displayed

Examples:
|productName|
|JBL Flip 5|