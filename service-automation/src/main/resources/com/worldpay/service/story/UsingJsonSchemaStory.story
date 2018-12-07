Narrative: Validate response against a json schema

Meta:
@UsingJsonSchemaStory

Scenario: Send a GET request and validate the response against a json schema

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


Scenario: Send POST request with a nested body

Meta:
@UsingJsonSchemaStory020
Given table file location table for request: data/tables/NestedRequestExample.table
Given test data for API:
| key           	| value            	                   |
| api           	| <api>  	                           |
| server.protocol   |  https                               |
| server.host       | jsonplaceholder.typicode.com         |
| server.port       |                                      |
| json.schema       |        <schema>                      |
When I create JSON request
Given test data for headers:
| key         | value							|
| headerName  | Content-Type			        |
| headerValue | application/json				|
When I set request specification for server
When I post the JSon request with custom parameters
Then I can validate the response against the json schema

Examples:

| <api>          | <schema>                                                          |
| /posts         | com/worldpay/service/schemas/NestedResponeSchema.json             |
