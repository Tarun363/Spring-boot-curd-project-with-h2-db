package com.project.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.customer.entity.Customer;
import com.project.customer.exception.CustomerNotFoundException;
import com.project.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	/**
	 * Adds the customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	public Customer addCustomer(Customer customer) {
		if (customer.getName() == null)
			throw new CustomerNotFoundException(HttpStatus.BAD_REQUEST, "Name is required");
		if (customer.getAge() == null)
			throw new CustomerNotFoundException(HttpStatus.BAD_REQUEST, "Age is required");

		return customerRepository.save(customer);
	}

	/**
	 * Gets the all customers.
	 *
	 * @return the all
	 */
	public List<Customer> getAllCustomers() {
		return customerRepository.findAllByOrderByNameAsc();
	}

	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 */
	public Customer getCustomerById(Integer id) {
		Customer customer = customerRepository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException(HttpStatus.BAD_REQUEST, "No customer found with " + id));
		return customer;
	}

	/**
	 * Update customer by id.
	 *
	 * @param id          the id
	 * @param customerObj the customer obj
	 * @return the customer
	 */
	public Customer updateCustomerById(Integer id, Customer customerObj) {

		Customer customer = customerRepository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException(HttpStatus.BAD_REQUEST, "No customer found with " + id));

		if (customerObj.getName() != null) {
			customer.setName(customerObj.getName());
		}
		if (customerObj.getAge() != null) {
			customer.setAge(customerObj.getAge());
		}

		return customerRepository.save(customer);
	}

}
