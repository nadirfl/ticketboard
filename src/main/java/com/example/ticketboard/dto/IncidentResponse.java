package com.example.ticketboard.dto;

import com.example.ticketboard.domain.IncidentSeverity;
import com.example.ticketboard.domain.IncidentStatus;

import java.time.Instant;

public class IncidentResponse extends IncidentDto {
    private Long id;
    private IncidentStatus status;
    private IncidentSeverity severity;
    private String resolution;
    private Instant createdAt;

    public IncidentResponse(String title, String description, IncidentStatus status, IncidentSeverity severity, Instant createdAt, String resolution) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public IncidentSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(IncidentSeverity severity) {
        this.severity = severity;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
