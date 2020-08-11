package com.Eventregistration.api;

import java.net.URI;
import java.util.Optional;

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

import com.Eventregistration.domain.Customer;
import com.Eventregistration.repository.CustomersRepository;
import com.Eventregistration.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public Iterable<Customer> getAll() {
		return customerService.findAllCustomers();
	}

	@GetMapping("/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") long id){
		Optional<Customer> customer = customerService.findCustomerById(id);
		return customer;
	}

	@GetMapping("/byname/{name}")
	public Optional<Customer> getCustomerByName(@PathVariable("name") String name){
		Optional<Customer> customer = customerService.findCustomerByName(name);
		return customer;
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri){
		if (newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();			
		}
		customerService.saveCustomer(newCustomer);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response=ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("customerId") long customerId){
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();			
		}
		customerService.saveCustomer(newCustomer);		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") long customerId){
		if (customerId == 0) {
			return ResponseEntity.badRequest().build();			
		}
		customerService.deleteCustomerById(customerId);		
		return ResponseEntity.ok().build();
	}
	
}
