# AppDirect-assignment
Backend Coding Challenge

* Using scribe:1.3.5 for performing OAuth signature verification on the AppDirect issued API requests.
* Using Jaxb2Marshaller to read Event object returned from AppDirect
* Using mysql as a database resource


* Create a subscription (An account with creator and user details is saved to database, in-turn user is added to User table if it does not exist already)
* Assign a user to the recently created subscription (A user is added to access the Account)
	* If subscription doesn't exist ACCOUNT_NOT_FOUND is sent in response.
	* if user is already assigned to the subscription : USER_ALREADY_EXISTS
* Unassign the recently assigned user (A user is unassigned to access the Account, Not deleted from User table)
	* If subscription doesn't exist ACCOUNT_NOT_FOUND is sent in response.
	* If user does not exist : USER_NOT_FOUND
	* If you try to unassign creator, the application will return error code UNAUTHORIZED
* Change the subscription by changing the Edition ( Account status is changed to new Edition type)
* Cancel the subscription. (Account is delete from the database)
	* If subscription doesn't exist ACCOUNT_NOT_FOUND is sent in response
 
