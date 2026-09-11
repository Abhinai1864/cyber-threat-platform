package com.cyberthreat.platform.exception;

public class ThreatNotFoundException extends RuntimeException {

    public ThreatNotFoundException(String message) {
        super(message);
    }
}