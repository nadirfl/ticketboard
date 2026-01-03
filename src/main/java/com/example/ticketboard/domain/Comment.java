package com.example.ticketboard.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "incident_id", nullable = false)
    private Incident incident;
    private String author;
    private String message;
    private LocalDateTime createdAt;

    protected Comment() {}

    public Comment(Incident incident, String author, String message, LocalDateTime createdAt) {
        this.incident = incident;
        this.author = author;
        this.message = message;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
