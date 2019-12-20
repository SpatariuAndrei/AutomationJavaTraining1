Meta:

Narrative:
As a user
I want to perform login action
So that I can access my account

Scenario: Login with valid eMAG credentials - DO NOT remember credentials
Given I open eMAG home page
And I navigate to login page
When I set email address field
When I press Continua button
When I set password field
When I UNCHECK box keep_email option
And I press Continua button after valid password
And I open user menu
Then I verify that user name Vetisan Vasile is displayed

Scenario: Login with valid username and invalid password
Given I open eMAG home page
And I navigate to login page
When I set email address field
And I press Continua button
And I set password field to WrongPass
When I UNCHECK box keep_email option
And I press Continua button after invalid password
Then I verify that Ai introdus gresit parola sau adresa de email. Te rog completeaza din nou. error message appears

Scenario: Login with social media account - google account
Given I open eMAG home page
And I navigate to login page
When I click on Google login option
And I set google email as email address
And I press Next button on google login for password
And I set google password account as password
And I press Next button on google login form with window focus change
And I open user menu
Then I verify that user name Vetisan Vasile is displayed