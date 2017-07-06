Web application based on Spring Boot 1.4  where a groundbreaking broadcaster has testing new sale channels to its customers.


It is composed by two steps:
 * Products list
 * Order resume page (Checkout)

For testing purposes is only available with an H2 database, but it could be extended to work in different environments (TEST, LIVE) and databases (MySQL, ...)

The user ID is stored in a "customerId" cookie.

To build and run the application you should use the following commands at the command prompt:
```
gradle clean build
gradle bootRun
```

When the application is running, you can access it by going to the url address:
```
http://localhost:8080
```

You can run unit tests by running the following command at the command prompt:
```
gradle clean test
```

This tests validate the services calls and the API services.

For web testing there are some considerations:
 * A default "customerId" cookie is set to 1, and is reset to this value everytime products page is loaded.
 * To change the cookie value and refresh the products list, you should use the JavaScript function changeCookieIdAndRefreshAjax(<ID>) vía browser developer console. <ID> is an integer number.
 * There are no Home page, always is redirected to the Products page


The use cases defined for web testing are:
 * Test 1
 	* Access http://localhost:8080
 	* Select some products, the basket changes its list
 	* Click checkout button
 	* Browser goes to checkout page which shows the summary of the basket

 * Test 2
 	* Access http://localhost:8080
	* Execute the Javascript function changeCookieIdAndRefreshAjax(2); at the browser developer console, the products showed change.
 	* Select some products, the basket changes its list
 	* Click checkout button
 	* Browser goes to checkout page which shows the summary of the basket

 * Test 3
 	* Access http://localhost:8080
 	* Execute the Javascript function changeCookieIdAndRefreshAjax(5); at the browser developer console, the products lists are empty
