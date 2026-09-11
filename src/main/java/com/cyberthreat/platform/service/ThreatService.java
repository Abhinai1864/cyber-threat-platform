package com.cyberthreat.platform.service;

import com.cyberthreat.platform.dto.ThreatRequest;
import com.cyberthreat.platform.dto.ThreatResponse;
import com.cyberthreat.platform.entity.Threat;
import com.cyberthreat.platform.repository.ThreatRepository;
import org.springframework.stereotype.Service;
import com.cyberthreat.platform.exception.ThreatNotFoundException;

import java.util.List;

@Service
public class ThreatService {

    private final ThreatRepository threatRepository;

    public ThreatService(ThreatRepository threatRepository) {
        this.threatRepository = threatRepository;
    }

    public ThreatResponse createThreat(ThreatRequest request) {

        Threat threat = new Threat();

        threat.setTitle(request.getTitle());
        threat.setDescription(request.getDescription());
        threat.setSeverity(request.getSeverity());
        threat.setSource(request.getSource());
        threat.setStatus(request.getStatus());
        threat.setCreatedAt(request.getCreatedAt());

        Threat savedThreat = threatRepository.save(threat);

        return convertToResponse(savedThreat);
    }

    public List<ThreatResponse> getAllThreats() {

        return threatRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    public ThreatResponse getThreatById(Long id) {

        Threat threat = threatRepository.findById(id)
                .orElseThrow(() ->
                        new ThreatNotFoundException("Threat not found with id: " + id)
                );;

        return convertToResponse(threat);
    }

    private ThreatResponse convertToResponse(Threat threat) {

        return new ThreatResponse(
                threat.getId(),
                threat.getTitle(),
                threat.getDescription(),
                threat.getSeverity(),
                threat.getSource(),
                threat.getStatus(),
                threat.getCreatedAt()
        );
    }
    public ThreatResponse updateThreat(Long id, ThreatRequest request) {

        Threat threat = threatRepository.findById(id)
                .orElseThrow(() ->
                        new ThreatNotFoundException("Threat not found with id: " + id)
                );

        threat.setTitle(request.getTitle());
        threat.setDescription(request.getDescription());
        threat.setSeverity(request.getSeverity());
        threat.setSource(request.getSource());
        threat.setStatus(request.getStatus());
        threat.setCreatedAt(request.getCreatedAt());

        Threat updatedThreat = threatRepository.save(threat);

        return convertToResponse(updatedThreat);
    }
    public void deleteThreat(Long id) {

        if (!threatRepository.existsById(id)) {
            throw new ThreatNotFoundException(
                    "Threat not found with id: " + id
            );
        }

        threatRepository.deleteById(id);
    }
}