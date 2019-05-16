Meta:

Scenario: As a user I want to login on site and generate a report for every page displayed
Given Site was opened in resolution: <width> and <height>
And Home page was displayed
And I prepare a report for homePage with Galen for <device>
And I check for other elements on homePage for <device>
When I enter on loginPage
And I prepare a report for loginPage with Galen for <device>
And I login with valid values
Then AccountPage is displayed
And I prepare a report for accountPage with Galen for <device>
And I check for other elements on accountPage for <device>
And I logout from site
And I generate reports for loginTest for all devices and resolutions specified

Examples:
| device   | width  |  height |
| desktop  | 2560   | 1440    |
| tablet   | 1024   |  768    |
| mobile   | 550    |  950    |
