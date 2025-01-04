package com.panikbutonu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmergencyController {

    private final EmergencyService emergencyService;
    private final LocationService locationService;

    @Autowired
    public EmergencyController(EmergencyService emergencyService, LocationService locationService) {
        this.emergencyService = emergencyService;
        this.locationService = locationService;
    }

    @PostMapping("/emergency")
    public ResponseEntity<EmergencyResponse> handleEmergency(@RequestBody EmergencyRequest request) {
        try {
            EmergencyDetails details = emergencyService.processEmergency(request);
            return ResponseEntity.ok(new EmergencyResponse(
                "Emergency signal sent successfully",
                details.getTrackingId(),
                details.getTimestamp()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new EmergencyResponse(e.getMessage(), null, null));
        }
    }
} 