package com.example.ticketboard.service;

import com.example.ticketboard.domain.Incident;
import com.example.ticketboard.domain.IncidentStatus;
import com.example.ticketboard.dto.IncidentCreateRequest;
import com.example.ticketboard.dto.IncidentDto;
import com.example.ticketboard.dto.IncidentResponse;
import com.example.ticketboard.dto.IncidentUpdateRequest;
import com.example.ticketboard.exceptions.IncidentNotFoundException;
import com.example.ticketboard.mapper.IncidentMapper;
import com.example.ticketboard.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IncidentService implements IIncidentService {

    IncidentRepository incidentRepository;
    IncidentMapper incidentMapper;

    public IncidentService(IncidentRepository incidentRepository, IncidentMapper incidentMapper) {
        this.incidentRepository = incidentRepository;
        this.incidentMapper = incidentMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<IncidentResponse> getAllIncidents() {
        return incidentRepository.findAll()
                .stream()
                .map(incidentMapper::toIncidentResponseDto)
                .toList();
    }

    @Override
    public IncidentResponse createIncident(IncidentCreateRequest createRequest) {
        Incident incident= new Incident();
        incident.setTitle(createRequest.getTitle());
        incident.setDescription(createRequest.getDescription());
        incident.setSeverity(createRequest.getSeverity());
        incident.setResolution(createRequest.getResolution());
        incident.setStatus(IncidentStatus.OPEN);

        Incident saved = incidentRepository.save(incident);
        return incidentMapper.toIncidentResponseDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public IncidentResponse findIncidentById(Long incidentID) {
        Incident incident = incidentRepository.findById(incidentID)
                .orElseThrow(() -> new IncidentNotFoundException(incidentID));
        return incidentMapper.toIncidentResponseDto(incident);
    }

    @Override
    public IncidentResponse updateIncident(Long incidentID, IncidentUpdateRequest updateRequest) {
        Incident incident = incidentRepository.findById(incidentID)
                .orElseThrow(() -> new IncidentNotFoundException(incidentID));
        incident.setTitle(updateRequest.getTitle());
        incident.setDescription(updateRequest.getDescription());
        incident.setStatus(updateRequest.getStatus());
        incident.setSeverity(updateRequest.getSeverity());
        incident.setResolution(updateRequest.getResolution());

        Incident saved = incidentRepository.save(incident);
        return incidentMapper.toIncidentResponseDto(saved);
    }

    @Override
    public void deleteIncident(Long incidentID) {
        if (!incidentRepository.existsById(incidentID)) {
            throw new IncidentNotFoundException(incidentID);
        }
        incidentRepository.deleteById(incidentID);
    }
}
