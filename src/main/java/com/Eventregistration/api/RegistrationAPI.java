package com.Eventregistration.api;

import java.net.URI;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.Eventregistration.domain.Registration;
import com.Eventregistration.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationAPI {
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping
	public Iterable<Registration> getAll() {
		return registrationService.findAllRegistrations();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Registration> getCustomerById(@PathVariable("id") long id){
		Optional<Registration> registration = registrationService.findRegistrationById(id);
		if (registration.isPresent()) {
			return ResponseEntity.ok(registration.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri){
		if (newRegistration.getId() !=0 || newRegistration.getCustomer_id() == 0 || newRegistration.getEvent_id() == 0 || newRegistration.getRegistration_date() == null || newRegistration.getNotes() == null) {
			return ResponseEntity.badRequest().build();			
		}
		registrationService.saveRegistration(newRegistration);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response=ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{registrationId}")
	public ResponseEntity<?> putEvent(@RequestBody Registration newRegistration, @PathVariable("registrationId") long registrationId){
		if (newRegistration.getId() != registrationId || newRegistration.getCustomer_id() == 0 || newRegistration.getEvent_id() == 0 || newRegistration.getRegistration_date() == null || newRegistration.getNotes() == null) {
			return ResponseEntity.badRequest().build();			
		}
		registrationService.saveRegistration(newRegistration);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{registrationId}")
	public ResponseEntity<?> deleteEvent(@PathVariable("registrationId") long registrationId){
		if (registrationId == 0) {
			return ResponseEntity.badRequest().build();			
		}
		registrationService.deleteRegistrationById(registrationId);		
		return ResponseEntity.ok().build();
	}
	
}
