Narrative:

In order to show the login functionality
As a user
I want to log in

Scenario: Log in with existing email

Given I am on home page emag
And I want to log in
When I enter existing email
Then I'm prompted to enter my password
And I'm logged in

Scenario: Log in with an nonexisting email

Given I am on home page emag
And I want to log in
When I enter new email
Then I'm redirected to the register page to create a new account
And I'm logged in