package com.example.ticketboard.service;

import com.example.ticketboard.domain.Incident;
import com.example.ticketboard.dto.IncidentCreateRequest;
import com.example.ticketboard.dto.IncidentDto;
import com.example.ticketboard.dto.IncidentResponse;
import com.example.ticketboard.dto.IncidentUpdateRequest;

import java.util.List;

public interface IIncidentService {

    List<IncidentResponse> getAllIncidents();

    IncidentResponse createIncident(IncidentCreateRequest createRequest);

    IncidentResponse findIncidentById(Long incidentID);

    IncidentResponse updateIncident(Long id, IncidentUpdateRequest updateRequest);

    void deleteIncident(Long incidentID);
}
