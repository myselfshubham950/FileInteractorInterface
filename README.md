# FileInteractorInterface
This service is used for validating the request and then sent for further processing to FileInteractorImplementor. This service has been configured to run on http://localhost:8081 hostname.
3 endpoints are available:
/store -> POST
/update -> POST
/read -> GET

Sample request:
{
	"header":{
		"transId": "transId",
		"fileType": "CSV"
	},
	"name": "Shubham Goel",
	"dob": "20/07/1995",
	"salary": "52000",
	"age": 25
	"updatedName": "Shubham Goel 1",
	"updatedDob": "20/07/1995",
	"updatedSalary": "52000",
	"updatedAge": 25
}
