package com.example.ticketboard.dto;

import com.example.ticketboard.domain.IncidentSeverity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IncidentCreateRequest extends IncidentDto {

    @NotNull
    private IncidentSeverity incidentSeverity;

     @Size(max = 4000)
    private String resolution;

    public @NotNull IncidentSeverity getSeverity() {
        return incidentSeverity;
    }

    public void setSeverity(@NotNull IncidentSeverity incidentSeverity) {
        this.incidentSeverity = incidentSeverity;
    }

    public @Size(max = 4000) String getResolution() {
        return resolution;
    }

    public void setResolution(@Size(max = 4000) String resolution) {
        this.resolution = resolution;
    }
}
