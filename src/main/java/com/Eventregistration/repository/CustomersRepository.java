package com.Eventregistration.repository;

import java.util.Collection;

import com.Eventregistration.domain.Customer;

public interface CustomersRepository {

	public Collection<Customer> findAll();

	public Customer findById(Long id);
	
	public Collection<Customer> findByName(String name);
}
