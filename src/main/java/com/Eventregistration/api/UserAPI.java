package com.Eventregistration.api;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eventregistration.domain.Customer;
import com.Eventregistration.domain.User;
import com.Eventregistration.service.CustomerService;

@RestController
@RequestMapping("/verifyuser")
public class UserAPI {
	
	private User user;
	@Autowired	
	CustomerService customerService;
	
	@PostMapping
	@ResponseBody	
	public boolean verifyUser(@RequestBody User user){
				
		if (user.getName() == null || user.getPassword() == null) {
			return false;			
		}
		
		Customer customer = customerService.findCustomerByName(user.getName());

		if (customer != null) {
		
			if (customer.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
		
	}
		
}
