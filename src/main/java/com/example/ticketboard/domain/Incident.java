package com.example.ticketboard.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private IncidentStatus incidentStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private IncidentSeverity incidentSeverity;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(length = 4000)
    private String resolution;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }

    public Incident() {}

    public Incident(String title, String description, IncidentStatus incidentStatus, IncidentSeverity incidentSeverity, Instant createdAt, String resolution) {
        this.title = title;
        this.description = description;
        this.incidentStatus = incidentStatus;
        this.incidentSeverity = incidentSeverity;
        this.createdAt = createdAt;
        this.resolution = resolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncidentStatus getStatus() {
        return incidentStatus;
    }

    public void setStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public IncidentSeverity getSeverity() {
        return incidentSeverity;
    }

    public void setSeverity(IncidentSeverity incidentSeverity) {
        this.incidentSeverity = incidentSeverity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
