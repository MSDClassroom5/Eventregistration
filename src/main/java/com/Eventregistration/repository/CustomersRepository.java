package com.Eventregistration.repository;

import java.util.Collection;

import com.Eventregistration.domain.Customers;

public interface CustomersRepository {

	public Collection<Customers> findAll();

	public Customers findById(Long id);
	
}
