package com.Eventregistration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.Eventregistration.domain.Registrations;

@Component
public class InMemoryRegistrationsRepository implements RegistrationsRepository {

	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<Registrations> registrationsData = new ArrayList<>(Arrays.asList(
			new Registrations(1L, 1L, 1L, new Date(), "notes1"),
			new Registrations(2L, 2L, 2L, new Date(), "notes2"),
			new Registrations(3L, 3L, 3L, new Date(), "notes3"),
			new Registrations(4L, 4L, 4L, new Date(), "notes4"),
			new Registrations(5L, 5L, 5L, new Date(), "notes5")));


	@Override
	public Registrations findById(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.
		Optional<Registrations> regOptional = registrationsData.stream().filter(reg -> reg.getId() == (id))
				.findAny();

		return regOptional.orElse(null); // Returns item if found, else returns null
	}

	@Override
	public Collection<Registrations> findAll() {
		return Collections.unmodifiableCollection(registrationsData);
	}
//
//	@Override
//	public Collection<StockAccount> findByName(String name) {
//		return accountData.stream().filter(account -> account.getName().toLowerCase().equals(name.toLowerCase()))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public long count() {
//		return accountData.size();
//	}
//
//	@Override
//	public StockAccount save(StockAccount account) {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public void delete(StockAccount account) {
//		throw new UnsupportedOperationException();
//	}

}
