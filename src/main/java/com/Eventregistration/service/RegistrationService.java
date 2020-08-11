package com.Eventregistration.service;

import com.Eventregistration.domain.Registration;

public interface RegistrationService {
//	public void saveCustomer(Customers customer);
	public Iterable<Registration> findAllRegistrations();
	public Registration findRegistrationById(long id);	
}