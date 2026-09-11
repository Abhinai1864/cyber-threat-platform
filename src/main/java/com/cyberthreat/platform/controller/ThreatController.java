package com.cyberthreat.platform.controller;

import com.cyberthreat.platform.dto.ThreatRequest;
import com.cyberthreat.platform.dto.ThreatResponse;
import com.cyberthreat.platform.service.ThreatService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/threats")
public class ThreatController {

    private final ThreatService threatService;

    public ThreatController(ThreatService threatService) {
        this.threatService = threatService;
    }

    @PostMapping
    public ThreatResponse createThreat(
            @Valid @RequestBody ThreatRequest request) {

        return threatService.createThreat(request);
    }

    @GetMapping
    public List<ThreatResponse> getAllThreats() {

        return threatService.getAllThreats();
    }

    @GetMapping("/{id}")
    public ThreatResponse getThreatById(@PathVariable Long id) {

        return threatService.getThreatById(id);
    }
    @PutMapping("/{id}")
    public ThreatResponse updateThreat(
            @PathVariable Long id,
            @Valid @RequestBody ThreatRequest request) {

        return threatService.updateThreat(id, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThreat(@PathVariable Long id) {

        threatService.deleteThreat(id);

        return ResponseEntity.noContent().build();
    }
}