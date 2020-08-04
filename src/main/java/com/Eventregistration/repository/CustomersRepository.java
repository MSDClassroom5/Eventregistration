package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;

import com.Eventregistration.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}
