package com.example.ticketboard.repository;

import com.example.ticketboard.domain.Incident;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncidentRepository extends CrudRepository<Incident, Long> {

    List<Incident> findByTitle(String title);

    Incident findById(long id);
}
