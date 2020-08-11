package com.Eventregistration.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eventregistration.domain.Registration;
import com.Eventregistration.repository.RegistrationsRepository;
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
	public Optional<Registration> getCustomerById(@PathVariable("id") long id){
		return registrationService.findRegistrationById(id);
	}
	
//	@PostMapping
//	public ResponseEntity<?> addCustomer(@RequestBody Customers newCustomer, UriComponentsBuilder uri){
//		if (newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
//			return ResponseEntity.badRequest().build();			
//		}
//		newCustomer = repo.save(newCustomer);
//		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
//		ResponseEntity<?> response=ResponseEntity.created(location).build();
//		return response;
//	}
//
//	@PutMapping("/{customerId}")
//	public ResponseEntity<?> putCustomer(@RequestBody Customers newCustomer, @PathVariable("customerId") long customerId){
//		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
//			return ResponseEntity.badRequest().build();			
//		}
//		newCustomer = repo.save(newCustomer);
//		return ResponseEntity.ok().build();
//	}
	
}
