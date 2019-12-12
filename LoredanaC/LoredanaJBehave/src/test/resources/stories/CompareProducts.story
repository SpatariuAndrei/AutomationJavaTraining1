Scenario: Compare prices for two items

Given I search for macbook
When I get the prices for two items
Then Price of first item should be greater
