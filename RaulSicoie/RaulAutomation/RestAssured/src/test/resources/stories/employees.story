Meta:

Narrative:
As a user
I want to make e http request
So that I can create 5 new employees in DB

Scenario: create 5 new records in DB
Given I make a request to base url
When I add  <employee>
Then the response is 200

Examples:
|employee                                   |
|{"name":"test 1","salary":"100","age":"11"}|
|{"name":"test 2","salary":"200","age":"21"}|
|{"name":"test 3","salary":"300","age":"31"}|