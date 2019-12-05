Meta:

Narrative:
As a user
I want to perform login action
So that I can access my account

Secnario: Login with valid eMAG credentials - DO NOT remember credentials
Given I open eMAG home page
And I navigate to login page
When I set email address field
When I press Continua button
When I set password field
When I UNCHECK box keep_email option
And I press Continua button after valid password
And I open user menu
Then I verify that user name Vetisan Vasile is displayed