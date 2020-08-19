package com.Eventregistration.api;

import java.net.URI;
import java.util.Optional;

import org.json.simple.JSONObject;
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
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") long id){
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isPresent()) {
			return ResponseEntity.ok(customer.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/byname/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name){
		Customer customer = customerService.findCustomerByName(name);
		if (customer == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(customer);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri){
		if (newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null || newCustomer.getPassword() == null) {
			return ResponseEntity.badRequest().build();			
		}
		customerService.saveCustomer(newCustomer);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response=ResponseEntity.created(location).build();
		return response;
	}

	@PostMapping("/register-user")
	public ResponseEntity<?> registerCustomer(@RequestBody JSONObject userJsonObject){
		
		String userName = (String)userJsonObject.get("userName");
		String password = (String)userJsonObject.get("password");
		String email = (String)userJsonObject.get("email");
		
		if (userName == null || password == null || email == null) {
			return ResponseEntity.badRequest().build();			
		}
		Customer newCustomer = new Customer(userName, password, email);

		customerService.saveCustomer(newCustomer);
		ResponseEntity<?> response=ResponseEntity.ok(Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("customerId") long customerId){
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null || newCustomer.getPassword() == null) {
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
