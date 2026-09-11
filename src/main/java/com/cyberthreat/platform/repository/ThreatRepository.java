package com.cyberthreat.platform.repository;

import com.cyberthreat.platform.entity.Threat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreatRepository extends JpaRepository<Threat, Long> {
}