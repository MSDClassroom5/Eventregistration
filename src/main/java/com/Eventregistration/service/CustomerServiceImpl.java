package com.Eventregistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eventregistration.domain.Customer;
import com.Eventregistration.repository.CustomersRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomersRepository repo;


	public void saveCustomer(Customer customer) {
		repo.save(customer);
	}


	public Iterable<Customer> findAllCustomers() {
		return repo.findAll();
	}


	public Optional<Customer> findCustomerById(long id) {
		return repo.findById(id);
	}
	
	@Override
	public Customer findCustomerByName(String name) {
		return repo.findByNameIgnoreCase(name);
	}

	public void deleteCustomerById(long id){
		repo.deleteById(id);
	}
	
	
	
}


