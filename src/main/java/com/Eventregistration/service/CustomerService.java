package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Customer;

public interface CustomerService {
//	public void saveCustomer(Customers customer);
	public Iterable<Customer> findAllCustomers();
	public Customer findCustomerById(long id);	
}