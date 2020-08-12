package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Event;

public interface EventService {
	public void saveEvent(Event event);
	public Iterable<Event> findAllEvents();
	public Optional<Event> findEventById(long id);	
	public void deleteEventById(long id);
}