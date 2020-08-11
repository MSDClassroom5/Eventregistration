package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Event;

public interface EventService {
//	public void saveEvent(Events event);
	public Iterable<Event> findAllEvents();
	public Event findEventById(long id);	
}