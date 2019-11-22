Scenario: the scope of this test is to go to authentication form page and try login functionality

Given I open form authentication page
When I enter username tomsmith and password SuperSecretPassword!
Then I should see Welcome to the Secure Area on Secure Area page