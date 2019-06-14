Meta:

Scenario: As a user I want to enter on blog section and display the first post
Given Site was opened in resolution: <width> and <height>
And Home page was displayed
And I prepare a report for homePage with Galen for <device>
And I check for other elements on homePage for <device>
When I enter on blogListPage
Then I validate the blogListPage
When I prepare a report for blogListPage with Galen for <device>
And I check for other elements on blogListPage for <device>
And I select a blog from displayed list
Then I prepare a report for blogPage with Galen for <device>
And I check for other elements on blogPage for <device>
And I generate reports for blogSelectionTest for all devices and resolutions specified

Examples:
| device   | width  |  height |
| desktop  | 2560   | 1440    |
| tablet   | 1024   |  768    |
| mobile   | 550    |  950    |
