package com.example.ticketboard.dto;

import com.example.ticketboard.domain.Incident;

import java.time.Instant;

public class CommentResponse {

    private Long id;
    private Incident incident;
    private String author;
    private String message;
    private Instant createdAt;

    public CommentResponse(Long id, Incident incident, String author, String message, Instant createdAt) {
        this.id = id;
        this.incident = incident;
        this.author = author;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
