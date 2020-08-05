package com.Eventregistration.repository;

import java.util.Collection;

import com.Eventregistration.domain.Events;

public interface EventsRepository {
	public Collection<Events> findAll();

	public Events findById(Long id);
}
