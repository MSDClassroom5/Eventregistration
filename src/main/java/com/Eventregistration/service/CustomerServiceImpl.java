package com.Eventregistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eventregistration.domain.Customers;
import com.Eventregistration.repository.CustomersRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomersRepository repo;


//	public void saveCustomer(Customers customer) {
//		repo.save(customer);
//	}


	public Iterable<Customers> findAllCustomers() {
		return repo.findAll();
	}


	public Customers findCustomerById(long id) {
		return repo.findById(id);
	}
}


