package com.example.ticketboard.controller;

import com.example.ticketboard.domain.Incident;
import com.example.ticketboard.dto.IncidentCreateRequest;
import com.example.ticketboard.dto.IncidentDto;
import com.example.ticketboard.dto.IncidentResponse;
import com.example.ticketboard.dto.IncidentUpdateRequest;
import com.example.ticketboard.service.IIncidentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IIncidentService incidentService;

    public IncidentController(IIncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public ResponseEntity<List<IncidentResponse>> getIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

    @PostMapping
    public ResponseEntity<IncidentResponse> createIncident(@Valid @RequestBody IncidentCreateRequest createRequest) {
        IncidentResponse created = incidentService.createIncident(createRequest);
        URI location = URI.create("/incidents/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentResponse> findIncidentById(@PathVariable Long incidentID) {
        return ResponseEntity.ok(incidentService.findIncidentById(incidentID));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidentResponse> updateIncident(
            @PathVariable Long incidentID,
            @Valid @RequestBody IncidentUpdateRequest updateRequest
    ) {
        return ResponseEntity.ok(incidentService.updateIncident(incidentID, updateRequest));
    }

    @DeleteMapping("/{id}}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long incidentID) {
        incidentService.deleteIncident(incidentID);
        return ResponseEntity.noContent().build();
    }
}
