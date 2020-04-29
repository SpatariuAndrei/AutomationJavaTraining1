Narrative:
As a user
I want to sign up on pcgarage.ro
So I can buy stuff later

Scenario: Trying to sign up with an already existing user
Given I go to PCGarage <homePage>
When I go to My account
When I sign up
Then I get an error message

Examples:
|homePage|
|https://www.pcgarage.ro/|

Scenario: Trying to sign up with an already existing user again
Given I go to PCGarage <homePage>
When I go to My account
When I sign up
Then I get an error message

Examples:
|homePage|
|https://www.pcgarage.ro/|