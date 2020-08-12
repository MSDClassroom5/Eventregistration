package com.Eventregistration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eventregistration.domain.Event;

@Repository
public interface EventsRepository extends CrudRepository<Event, Long>  {
}
