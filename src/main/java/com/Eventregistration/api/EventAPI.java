package com.Eventregistration.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.Eventregistration.domain.Events;
import com.Eventregistration.repository.EventsRepository;

@RestController
@RequestMapping("/events")
public class EventAPI {
	
	@Autowired
	EventsRepository repo;
	
	@GetMapping
	public Iterable<Events> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{eventId}")
	public Events getEventById(@PathVariable("eventId") long id){
		return repo.findById(id);
	}
	
//	@PostMapping
//	public ResponseEntity<?> addEvent(@RequestBody Events newEvent, UriComponentsBuilder uri){
//		if (newEvent.getId() !=0 || newEvent.getName() == null || newEvent.getEmail() == null) {
//			return ResponseEntity.badRequest().build();			
//		}
//		newEvent = repo.save(newEvent);
//		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId()).toUri();
//		ResponseEntity<?> response=ResponseEntity.created(location).build();
//		return response;
//	}
//
//	@PutMapping("/{eventId}")
//	public ResponseEntity<?> putEvent(@RequestBody Events newEvent, @PathVariable("eventId") long eventId){
//		if (newEvent.getId() != eventId || newEvent.getName() == null || newEvent.getEmail() == null) {
//			return ResponseEntity.badRequest().build();			
//		}
//		newEvent = repo.save(newEvent);
//		return ResponseEntity.ok().build();
//	}
	
}
