Scenario: load tabular data from a file in order to modify my profile on Emag

Given I navigate to my personal data page to edit data
And I stream my test data: /src/test/resources/testdata/personalData.table
And I populate my account with data
Then I check that data was populated correctly

