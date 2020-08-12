package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Customer;

public interface CustomerService {
	public void saveCustomer(Customer customer);
	public Iterable<Customer> findAllCustomers();
	public Optional<Customer> findCustomerById(long id);
	public Optional<Customer> findCustomerByName(String name);
	public void deleteCustomerById(long id);
}