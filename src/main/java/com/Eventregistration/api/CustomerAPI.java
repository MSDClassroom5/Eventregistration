package com.Eventregistration.api;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.Eventregistration.domain.Customer;
import com.Eventregistration.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	
	@Autowired
	CustomersRepository repo;
	
	@GetMapping
	public Iterable<Customer> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") long id){

		return repo.findById(id);
	}

	@GetMapping("/byname/{name}")
	public Optional<Customer> getCustomerByName(@PathVariable("name") String name){
		return repo.findById((long)0);
//		return repo.findByName(name);

	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri){
		if (newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();			
		}
		newCustomer = repo.save(newCustomer);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response=ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("customerId") long customerId){
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();			
		}
		newCustomer = repo.save(newCustomer);
		return ResponseEntity.ok().build();
	}
	
}
