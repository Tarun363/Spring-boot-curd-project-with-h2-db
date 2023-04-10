package com.project.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/**
	 * Find all order by name.
	 *
	 * @return the list
	 */
	List<Customer> findAllByOrderByNameAsc();

}
