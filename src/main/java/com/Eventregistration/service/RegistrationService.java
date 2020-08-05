package com.Eventregistration.service;

import com.Eventregistration.domain.Registrations;

public interface RegistrationService {
//	public void saveCustomer(Customers customer);
	public Iterable<Registrations> findAllRegistrations();
	public Registrations findRegistrationById(long id);	
}