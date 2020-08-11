package com.Eventregistration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.Eventregistration.domain.Customer;

@Repository
public class InMemoryCustomersRepository implements CustomersRepository {

	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<Customer> accountData = new ArrayList<>(Arrays.asList(
			new Customer(1L, "John", "password", "John@email.com"),
			new Customer(2L, "Linda", "password", "Linda@email.com"), 
			new Customer(3L, "Jose", "password", "Jose@email.com"),
			new Customer(4L, "Teresa", "password", "Teresa@email.com"), 
			new Customer(5L, "Bill", "password", "Bill@email.com")));


	@Override
	public Customer findById(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.
		Optional<Customer> customerOptional = accountData.stream().filter(customer -> customer.getId() == (id))
				.findAny();

		return customerOptional.orElse(null); // Returns item if found, else returns null
	}

	@Override
	public Collection<Customer> findAll() {
		return Collections.unmodifiableCollection(accountData);
	}

	@Override
	public Collection<Customer> findByName(String name) {
		return accountData.stream().filter(customer -> customer.getName().toLowerCase().equals(name.toLowerCase()))
				.collect(Collectors.toList());
	}
//
//	@Override
//	public long count() {
//		return accountData.size();
//	}
//
//	@Override
//	public StockAccount save(StockAccount account) {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public void delete(StockAccount account) {
//		throw new UnsupportedOperationException();
//	}

}
