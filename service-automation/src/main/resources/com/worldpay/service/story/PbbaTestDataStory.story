Scenario: Send PBBA the merchant registration information and receive the response from PBBA using table file

Given table file location table for merchant registration: data/tables/MerchantRegistration.table
Given test data for Merchant Registration:
| key          											| value		|
| merchant.id											| 111111	|
| merchant.registrationInfo.address.countryCode			| ROU		|
When create JSON request
Given test data for API:
| key          	| value            		|
| api          	| payByBankApp   		|
| action		| merchant/registration |
When I post the JSon request
Given test data for the response:
| key          											| value		|
| merchantId											| 111111	|
Then I can validate the response

Scenario: Send PBBA the merchant registration information and receive the response from PBBA

Given test data cleared
Given test data for Merchant Registration:
| key          											| value		|
| merchant.id											| 000000	|
| merchant.registrationInfo.address.addressLine1		| string	|
| merchant.registrationInfo.address.countryCode			| GBR		|
| merchant.registrationInfo.address.postCode			| string	|
| merchant.registrationInfo.categoryCode				| 1			|
| merchant.registrationInfo.commonName					| string	|
| merchant.registrationInfo.creditAccount.accountNumber	| string	|
| merchant.registrationInfo.creditAccount.rollNumber	| string	|
| merchant.registrationInfo.creditAccount.sortCode		| 814789	|
| merchant.registrationInfo.groupId						| string	|
| merchant.registrationInfo.keyId						| string	|
| merchant.registrationInfo.logoUrl						| string	|
| merchant.registrationInfo.name						| string	|
When create JSON request
Given test data for API:
| key          	| value            		|
| api          	| payByBankApp   		|
| action		| merchant/registration |
When I post the JSon request
Then I can see the response
Given test data for the response:
| key          											| value		|
| merchantId											| 000000	|
Then I can validate the response