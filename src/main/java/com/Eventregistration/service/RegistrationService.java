package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Registration;

public interface RegistrationService {
//	public void saveCustomer(Customers customer);
	public Iterable<Registration> findAllRegistrations();
	public Optional<Registration> findRegistrationById(long id);
	public void saveRegistration(Registration registration);
	public void deleteRegistrationById(long id);	
}