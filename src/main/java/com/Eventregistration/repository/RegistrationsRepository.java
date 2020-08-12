package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;

import com.Eventregistration.domain.Registration;

public interface RegistrationsRepository extends CrudRepository<Registration, Long> {

//	public Collection<Registration> findAll();
//
//	public Registration findById(Long id);
	
}
