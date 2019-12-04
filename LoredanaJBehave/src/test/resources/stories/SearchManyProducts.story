Scenario: the scope of this test is to add many products on favorite list

Given I search for <product>
When I add the product to favorites
Then I verify the message

Examples:
|product|
|book|
|Samsung|
|bosch|