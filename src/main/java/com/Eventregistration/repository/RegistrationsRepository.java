package com.Eventregistration.repository;

import java.util.Collection;

import com.Eventregistration.domain.Registration;

public interface RegistrationsRepository {

	public Collection<Registration> findAll();

	public Registration findById(Long id);
	
}
