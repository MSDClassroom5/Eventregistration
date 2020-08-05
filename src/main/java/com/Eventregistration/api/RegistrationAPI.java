package com.Eventregistration.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eventregistration.domain.Registrations;
import com.Eventregistration.repository.RegistrationsRepository;

@RestController
@RequestMapping("/registrations")
public class RegistrationAPI {
	
	@Autowired
	RegistrationsRepository repo;
	
	@GetMapping
	public Iterable<Registrations> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Registrations getCustomerById(@PathVariable("id") long id){
		return repo.findById(id);
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
