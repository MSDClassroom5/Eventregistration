package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Customers;

public interface CustomerService {
//	public void saveCustomer(Customers customer);
	public Iterable<Customers> findAllCustomers();
	public Customers findCustomerById(long id);	
}