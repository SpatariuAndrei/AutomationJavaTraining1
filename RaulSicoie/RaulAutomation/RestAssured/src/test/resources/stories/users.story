Meta:

Narrative:
As a user
I want to get all the users, insert a new one and delete another
So that I can do all this operation with status code 200

Scenario: get,delete and insert an user
Given I store the name of users with id 3 in a string
And I insert a new user with id 5, username Raul, password pass
When I delete the user with id 2
Then the request response code should be 200