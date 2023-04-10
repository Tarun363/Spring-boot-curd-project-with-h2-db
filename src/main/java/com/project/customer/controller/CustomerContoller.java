package com.project.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.customer.entity.Customer;
import com.project.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerContoller {

	@Autowired
	CustomerService customerService;

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 */
	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}

	/**
	 * Adds the customer.
	 *
	 * @param customer the customer
	 * @return the response entity
	 */
	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	}

	/**
	 * Update customer.
	 *
	 * @param id          the id
	 * @param customerObj the customer obj
	 * @return the response entity
	 */
	@PutMapping("customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerObj) {
		return new ResponseEntity<Customer>(customerService.updateCustomerById(id, customerObj), HttpStatus.OK);
	}

}
