package com.example.ticketboard.dto;

import com.example.ticketboard.domain.IncidentSeverity;
import com.example.ticketboard.domain.IncidentStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IncidentUpdateRequest extends IncidentDto {

    @NotNull
    private IncidentStatus status;

    @NotNull
    private IncidentSeverity severity;

    @Size(max = 4000)
    private String resolution;

    public @NotNull IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(@NotNull IncidentStatus status) {
        this.status = status;
    }

    public @NotNull IncidentSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(@NotNull IncidentSeverity severity) {
        this.severity = severity;
    }

    public @Size(max = 4000) String getResolution() {
        return resolution;
    }

    public void setResolution(@Size(max = 4000) String resolution) {
        this.resolution = resolution;
    }
}
