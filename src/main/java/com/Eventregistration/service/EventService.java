package com.Eventregistration.service;

import java.util.Optional;

import com.Eventregistration.domain.Events;

public interface EventService {
//	public void saveEvent(Events event);
	public Iterable<Events> findAllEvents();
	public Events findEventById(long id);	
}