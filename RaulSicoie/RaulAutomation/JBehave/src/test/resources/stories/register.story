Meta:

Narrative:
As a user
I want to access eMag
So that I can register myself

Scenario: register a new account
Given I open eMag home page
And I log in
When I navigate to my personal data page
And I stream my test data: /resources/testdata/personalData.table
And I populate my account with data
Then I check that data was populated correctly

