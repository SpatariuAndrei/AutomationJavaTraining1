Scenario: the scope of this test is to login to emag

Given I open a browser
When I enter https://www.emag.ro/ and hit the enter key
Then eMAG.ro - Libertate în fiecare zi is displayed
When When I go to My account
When I click on Intra in cont
Then I should be redirected to Login form page where I enter my email loredanacoroamaa@gmail.com
When I click on continue
When I enter my password
Then After continue, I should see home page
When I go to my profile on favorite products
Then I should see Coroama Loredana as username
