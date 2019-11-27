Meta:

Narrative:
As a user
I want to add products to my whishlist
So that I can have my wishlist product

Scenario: Add search results products into my wishlist
Given I search for <product>
When I add the <product> to my wishlist
And I navigate to wishlist
Then I verify that <product> was added to my wishlist

Examples:
|product                                                   |
|Telefon mobil Apple iPhone 11, 64GB, Black                |
|Televizor LED Smart Samsung, 108 cm, 43RU7102, 4K Ultra HD|
|Televizor LED Smart Samsung, 80 cm, 32N5372, Full HD      |
