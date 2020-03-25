Narrative:

In order to show the basic cart functionality
As a user
I want to add and remove items from the cart

Scenario: Item can be added to cart

Given that the cart is empty
And I am on home page emag
When I search for scaun
And the first item is added to the cart
Then the cart contains an item

Scenario: Item can be removed from cart

Given the cart contains one item
When the item is removed
Then the cart will be empty