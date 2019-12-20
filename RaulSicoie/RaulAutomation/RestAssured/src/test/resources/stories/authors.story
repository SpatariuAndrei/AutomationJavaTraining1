

Narrative:
As a user
I want to search a book after a specific IDBook
So that I can return the name of the books authors with that IDBook

Scenario: return the name of authors
Given I make a request to base url
And I provide the /Authors
When I make the request I store the data in lists for every field
Then I check that the name of authors contains the ID value