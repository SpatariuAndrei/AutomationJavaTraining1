Narrative:
As a user
I want to search for a product on pcgarage.ro
So I can pick an item

Scenario: Search for the specific product from the homepage
Given I go to PCGarage <homePage>
When I search for <productName>
When I select the elements to compare
When I click on compare button
Then I verify if the products are displayed in the comparation list

Examples:
|homePage|productName|
|https://www.pcgarage.ro/|JBL Flip 5|