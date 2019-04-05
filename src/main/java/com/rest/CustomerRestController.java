package com.rest;

import com.entity.Customer;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 05.04.2019
 */

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    // mapping for GET /customers

    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();
    }

    // mapping for GET /customers/{customerId}

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer ID not found " + customerId);
        }

        return theCustomer;
    }

    // mapping for POST /customers  - add new customer

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    // mapping for PUT /customers - update existing customer

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    // mapping for DELETE /customers/{customerId} - delete customer

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);

        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found " + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer id " + customerId;
    }

    // mapping for POST /customers{search}  - search customers

    @PostMapping("/customers/{search}")
    public List<Customer> searchCustomers(@PathVariable String search) {

        List<Customer> tempList = customerService.searchCustomers(search);

        if (tempList.isEmpty()) {
            throw new CustomerNotFoundException("No matching in customers with " + search);
        }

        return tempList;
    }
}
