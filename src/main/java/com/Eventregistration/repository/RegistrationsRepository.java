package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eventregistration.domain.Registration;

@Repository
public interface RegistrationsRepository extends CrudRepository<Registration, Long> {

//	public Collection<Registration> findAll();
//
//	public Registration findById(Long id);
	
}
