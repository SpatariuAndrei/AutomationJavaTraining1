Narrative:
As a user
I want to sign in on pcgarage.ro
So I can see my account

Scenario: Trying to sign in with valid credentials
Given I go to PCGarage home page
When I go to My account
When I enter my username and password
Then I see my account

Scenario: Trying to sign in with invalid credentials
Given I go to PCGarage home page
When I go to My account
When I enter my wrong username and password
Then I get an error message
