package com.Eventregistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eventregistration.domain.Registration;
import com.Eventregistration.repository.RegistrationsRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationsRepository repo;

	public Iterable<Registration> findAllRegistrations() {
		return repo.findAll();
	}

	public Optional<Registration> findRegistrationById(long id) {
		return repo.findById(id);
	}

	public void saveRegistration(Registration registration) {
		repo.save(registration);
	}

	public void deleteRegistrationById(long id) {
		repo.deleteById(id);
	}
}


