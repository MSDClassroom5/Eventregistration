package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;

import com.Eventregistration.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

//	public Collection<Customers> findAll();
//
//	public Customers findById(Long id);
//	
//	public Collection<Customers> findByName(String name);
}
