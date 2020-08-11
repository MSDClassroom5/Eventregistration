package com.Eventregistration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.Eventregistration.domain.Customer;
import com.Eventregistration.domain.Event;

@Repository
public class InMemoryEventsRepository implements EventsRepository {

	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<Event> eventData = new ArrayList<>(Arrays.asList(
			new Event(1L, "E1", "Weekly Meeting", "Weekly meeting #1"),
			new Event(2L, "E2", "Sales Meeting", "Sales meeting FY2020"),
			new Event(3L, "E3", "Fun Meeting", "Happy Happy Meeting"),
			new Event(4L, "E4", "Covid Meeting", "Trash Fire FY2020"),
			new Event(5L, "E5", "Advertising Meeting", "Social Media Meeting")));


	@Override
	public Event findById(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.
		Optional<Event> eventOptional = eventData.stream().filter(event -> event.getId() == (id))
				.findAny();

		return eventOptional.orElse(null); // Returns item if found, else returns null
	}

	@Override
	public Collection<Event> findAll() {
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
