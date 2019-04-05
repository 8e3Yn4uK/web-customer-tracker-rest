# web-customer-tracker REST API

 CRM - Customer Relationship Manager

REST clients should be able to

* Get a list of customers 
* Get a single customer by id
* Add a new customer
* Update a customer
* Delete a customer
* Search for customer(s)

 
Secure REST APIs by Role

USER role can perform following
1. Get a list of all customers. GET /api/customers
2. Get a single customer. GET /api/customers/{customerId} 
3. Search customer(s). POST /api/customers/{search}

MANAGER role can perform following
1. Add a new customer. POST /api/customers
2. Update an existing customer. PUT /api/customers

ADMIN role can perform following
1. Delete a customer. DELETE /api/customers/{customerId} 






