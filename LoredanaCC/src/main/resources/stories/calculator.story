Meta:

Narrative:
As a user
I want to perform an operation
So that I can get the results of two numbers

Scenario: scenario Addition
Given a Calculator class with the operation sign as <sign>
When I give the first number as <number1>
 And I give the first number as <number2>
Then I should get the result as <result>

Examples:
|sign|number1|number2|result|
|+|3|4|7|