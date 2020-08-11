package com.Eventregistration.repository;

import java.util.Collection;

import com.Eventregistration.domain.Event;

public interface EventsRepository {
	public Collection<Event> findAll();

	public Event findById(Long id);
}
