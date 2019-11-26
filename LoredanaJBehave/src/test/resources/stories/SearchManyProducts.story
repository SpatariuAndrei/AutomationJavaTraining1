Scenario: the scope of this test is to add many products on favorite list

Given I open eMAG home page
When I search for <product>
And I add <product> to favorites
Then I check <product> appears in favorites

Examples:
|product|
|Iphone|
|Samsung|
|Nokia|