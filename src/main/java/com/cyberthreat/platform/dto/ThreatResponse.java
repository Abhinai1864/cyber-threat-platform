package com.cyberthreat.platform.dto;

import com.cyberthreat.platform.entity.Severity;

import java.time.LocalDateTime;

public class ThreatResponse {

    private Long id;
    private String title;
    private String description;
    private Severity severity;
    private String source;
    private String status;
    private LocalDateTime createdAt;

    public ThreatResponse() {
    }

    public ThreatResponse(Long id, String title, String description,
                          Severity severity, String source,
                          String status, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.source = source;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}