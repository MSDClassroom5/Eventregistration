package com.Eventregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eventregistration.domain.Registration;
import com.Eventregistration.repository.RegistrationsRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationsRepository repo;


//	public void saveCustomer(Customers customer) {
//		repo.save(customer);
//	}


	public Iterable<Registration> findAllRegistrations() {
		return repo.findAll();
	}


	public Registration findRegistrationById(long id) {
		return repo.findById(id);
	}
}


