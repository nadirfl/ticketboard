package com.example.ticketboard.exceptions;

public class IncidentNotFoundException extends RuntimeException {
    public IncidentNotFoundException(Long id) {
        super("Incident not found: " + id);
    }
}
