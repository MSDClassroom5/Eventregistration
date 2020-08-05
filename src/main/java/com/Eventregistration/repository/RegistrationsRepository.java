package com.Eventregistration.repository;

import java.util.Collection;

import com.Eventregistration.domain.Registrations;

public interface RegistrationsRepository {

	public Collection<Registrations> findAll();

	public Registrations findById(Long id);
	
}
