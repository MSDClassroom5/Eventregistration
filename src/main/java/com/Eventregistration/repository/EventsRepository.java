package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;

import com.Eventregistration.domain.Event;

public interface EventsRepository extends CrudRepository<Event, Long>  {
}
