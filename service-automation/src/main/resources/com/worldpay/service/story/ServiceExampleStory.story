Narrative: Service example using test data in story file or reading the data from table file
Meta:
@ServiceExampleStory


Scenario: Send a request and validate the response - using table file

Meta:
@ServiceExampleStory010

Given table file location table for merchant registration: data/tables/RequestExample.table
Given test data for Merchant Registration:
| key                                           | value  	|
| merchant.id                                   | "000000" 	|
| merchant.registrationInfo.address.countryCode | ROU    	|

When I create JSON request
Given test data for headers:
| key         | value                                      |
| headerName  | Content-Type;X-WP-Diagnostic-CorrelationId |
| headerValue | application/json;Db4JU93EYMIgHG1P          |
When I set request specification for server
Given test data for API:
| key    				| value                   |
| server.path.part1     | payByBankApp/merchant   |
| server.path.part2     | registration            |
When I post the JSon request
Given test data for the response:
| key          | value  |
| merchantId   | 000000 |
| responseCode | 201    |
Then I can validate the response
Then I check the response code


Scenario: Send a request and validate the response - using all the test data from story file

Meta:
@ServiceExampleStory020

Given test data cleared
Given test data for Merchant Registration:
| key                                                   | value  	|
| merchant.id                                           | "000000" 	|
| merchant.registrationInfo.address.addressLine1        | string 	|
| merchant.registrationInfo.address.countryCode         | GBR    	|
| merchant.registrationInfo.address.postCode            | string 	|
| merchant.registrationInfo.categoryCode                | 1      	|
| merchant.registrationInfo.commonName                  | string 	|
| merchant.registrationInfo.creditAccount.accountNumber | string 	|
| merchant.registrationInfo.creditAccount.rollNumber    | string 	|
| merchant.registrationInfo.creditAccount.sortCode      | 814789 	|
| merchant.registrationInfo.groupId                     | string 	|
| merchant.registrationInfo.keyId                       | string 	|
| merchant.registrationInfo.logoUrl                     | string 	|
| merchant.registrationInfo.name                        | string 	|
When I create JSON request
Given test data for headers:
| key         | value                                      |
| headerName  | Content-Type;X-WP-Diagnostic-CorrelationId |
| headerValue | application/json;Db4JU93EYMIgHG1P          |
When I set request specification for server
Given test data for API:
| key    | value                 |
| server.path.part1    | payByBankApp/merchant |
| server.path.part2    | registration          |
When I post the JSon request
Given test data for the response:
| key          | value  |
| merchantId   | 000000 |
| responseCode | 201    |
Then I can validate the response
Then I check the response code


Scenario: Send a request and validate the response - using json file

Meta:
@ServiceExampleStory030

Given test data cleared
Given test data for Merchant Registration:
| key               | value                  |
| json.request.path | data/json/request.json |
Given I read JSON request from file
Given test data for headers:
| key         | value                                      |
| headerName  | Content-Type;X-WP-Diagnostic-CorrelationId |
| headerValue | application/json;Db4JU93EYMIgHG1P          |
When I set request specification for server
Given test data for API:
| key    				| value                 |
| server.path.part1     | payByBankApp/merchant |
| server.path.part2     | registration          |
When I post the JSon request
Given test data for the response:
| key          | value  |
| merchantId   | 000000 |
| responseCode | 201    |
Then I can validate the response
Then I check the response code