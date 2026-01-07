package com.example.ticketboard.utils;

import com.example.ticketboard.domain.Comment;
import com.example.ticketboard.domain.Incident;
import com.example.ticketboard.domain.IncidentSeverity;
import com.example.ticketboard.domain.IncidentStatus;
import com.example.ticketboard.repository.CommentRepository;
import com.example.ticketboard.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DataSeeder implements CommandLineRunner {

    IncidentRepository incidentRepository;
    CommentRepository commentRepository;

    @Value("${app.seed.enabled:false}")
    private boolean seedEnabled;

    public DataSeeder(IncidentRepository incidentRepository, CommentRepository commentRepository) {
        this.incidentRepository = incidentRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!seedEnabled) return;

        if (incidentRepository.count() > 0) return;

        Incident incident = new Incident("Test", "Test", IncidentStatus.OPEN, IncidentSeverity.LOW, Instant.now(), "");
        incidentRepository.save(incident);

        Comment comment = new Comment(incident, "Test", "Test", Instant.now());
        commentRepository.save(comment);
    }
}
