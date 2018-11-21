Narrative: Validate response against a json schema

Meta:
@UsingJsonSchemaStory

Scenario: Send PBBA the merchant registration information and receive the response from PBBA using table file

Meta:
@UsingJsonSchemaStory010
Given test data for API:
| key           	| value            	                   |
| api           	| <api>  	                           |
| server.protocol   |  https                               |
| server.host       | jsonplaceholder.typicode.com         |
| server.port       |                                      |
| json.schema       |        <schema>                      |
When I get the JSon request with custom parameters
Then I can validate the response against the json schema

Examples:

| <api>        | <schema>                                                        |
| /todos/2     | com/worldpay/service/schemas/toDoResponeSchema.json             |
| /todos/5     | com/worldpay/service/schemas/toDoResponeSchema.json             |
| /users/1     | com/worldpay/service/schemas/userNoCompanyResponseSchema.json   |
| /users/5     | com/worldpay/service/schemas/userResponseSchema.json            |