package com.Eventregistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eventregistration.domain.Event;
import com.Eventregistration.repository.EventsRepository;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventsRepository repo;


//	public void saveEvent(Events event) {
//		repo.save(event);
//	}


	public Iterable<Event> findAllEvents() {
		return repo.findAll();
	}


	public Event findEventById(long id) {
		return repo.findById(id);
	}
}


