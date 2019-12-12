Scenario: Add product in favorite

Given I open eMag user home page
When I search the <product>
And I add it to favorites
And I navigate to favorites product page
Then I check that <product> is present

Examples:
|product       |
|Nokia 3310    |
|Samsung Galaxy|
|iPhone        |