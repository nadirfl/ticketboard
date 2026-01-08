package com.example.ticketboard.mapper;

import com.example.ticketboard.domain.Incident;
import com.example.ticketboard.dto.IncidentResponse;
import org.springframework.stereotype.Component;

@Component
public class IncidentMapper {

    public IncidentResponse toIncidentResponseDto(Incident incident) {
        System.out.println("IncidentMapper: " + incident.getTitle());
        return new IncidentResponse(
                incident.getId(),
                incident.getTitle(),
                incident.getDescription(),
                incident.getStatus(),
                incident.getSeverity(),
                incident.getCreatedAt(),
                incident.getResolution()
        );
    }
}
