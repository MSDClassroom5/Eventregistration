package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eventregistration.domain.Customer;

@Repository
public interface CustomersRepository extends CrudRepository<Customer, Long> {

//	public Collection<Customers> findAll();
//
//	public Customers findById(Long id);
//	
//	public Collection<Customers> findByName(String name);
	
	Customer findByNameIgnoreCase(String name);
}
