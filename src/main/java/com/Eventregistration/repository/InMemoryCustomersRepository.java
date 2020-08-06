package com.Eventregistration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Eventregistration.domain.Customers;

@Component
public class InMemoryCustomersRepository implements CustomersRepository {

	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<Customers> accountData = new ArrayList<>(Arrays.asList(
			new Customers(1L, "John", "password", "John@email.com"),
			new Customers(2L, "Linda", "password", "Linda@email.com"), 
			new Customers(3L, "Jose", "password", "Jose@email.com"),
			new Customers(4L, "Teresa", "password", "Teresa@email.com"), 
			new Customers(5L, "Bill", "password", "Bill@email.com")));


	@Override
	public Customers findById(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.
		Optional<Customers> customerOptional = accountData.stream().filter(customer -> customer.getId() == (id))
				.findAny();

		return customerOptional.orElse(null); // Returns item if found, else returns null
	}

	@Override
	public Collection<Customers> findAll() {
		return Collections.unmodifiableCollection(accountData);
	}

	@Override
	public Collection<Customers> findByName(String name) {
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
