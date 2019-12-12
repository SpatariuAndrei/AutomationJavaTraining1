Scenario: Login with valid eMAG credentials

Given I navigate to login page
When I set email address field
When I press Continua button
When I set password field
And I press Continua button after valid password
And I open user menu
Then I verify that user name Coroama Loredana is displayed


