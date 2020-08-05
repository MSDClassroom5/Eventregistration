package com.Eventregistration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.Eventregistration.domain.Customers;
import com.Eventregistration.domain.Events;

@Component
public class InMemoryEventsRepository implements EventsRepository {

	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<Events> eventData = new ArrayList<>(Arrays.asList(
			new Events(1L, "E1", "Weekly Meeting", "Weekly meeting #1"),
			new Events(2L, "E2", "Sales Meeting", "Sales meeting FY2020"),
			new Events(3L, "E2", "Fun Meeting", "Happy Happy Meeting"),
			new Events(4L, "E2", "Covid Meeting", "Trash Fire FY2020"),
			new Events(5L, "E2", "Advertising Meeting", "Social Media Meeting")));


	@Override
	public Events findById(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.
		Optional<Events> eventOptional = eventData.stream().filter(event -> event.getId() == (id))
				.findAny();

		return eventOptional.orElse(null); // Returns item if found, else returns null
	}

	@Override
	public Collection<Events> findAll() {
		return Collections.unmodifiableCollection(eventData);
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
