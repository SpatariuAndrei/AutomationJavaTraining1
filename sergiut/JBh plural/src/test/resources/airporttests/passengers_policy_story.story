Narrative:
As a company
I want to be able to manage passengers flights
So that the policies of the company are followed

Scenario: Economy flight, usual passanger
Given there is an economy flight
When we have a usual passenger
Then you can add and remove him from an economy flight
And you cannot add an usual passenger to an economy flight more than once

Scenario: Economy flight, VIP passenger
Given there is an economy flight
When we have a VIP passenger
Then you can add him but cannot remove him from an economy flight
And you cannot add a VIP passenger to an economy flight more than once

Scenario: Business flight, usual passenger
Given there is an business flight
When we have a usual passenger
Then you cannot add or remove him from a business flight

Scenario: Business flight, VIP passenger
Given there is an business flight
When we have a VIP passenger
Then you can add him but cannot remove him from a business flight
And you cannot add a VIP passenger to a business flight more than once

Scenario: Premium flight, usual passenger
Given there is an premium flight
When we have a usual passenger
Then you cannot add or remove him from a premium flight

Scenario: Premium flight, VIP passenger
Given there is an premium flight
When we have a VIP passenger
Then you can add and remove him from a premium flight
And you cannot add a VIP passenger to a premium flight more than once