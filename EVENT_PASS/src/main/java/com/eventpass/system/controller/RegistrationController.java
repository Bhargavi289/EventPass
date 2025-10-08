package com.eventpass.system.controller;

import com.eventpass.system.model.Registration;
import com.eventpass.system.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:5173") // change if your frontend runs on a different port
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Register a user for an event
    @PostMapping("/register")
    public ResponseEntity<Registration> register(@RequestParam Long userId, @RequestParam Long eventId) {
        Registration registration = registrationService.registerForEvent(userId, eventId);
        return ResponseEntity.ok(registration);
    }

    // Get all registrations of a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Registration>> getUserRegistrations(@PathVariable Long userId) {
        List<Registration> registrations = registrationService.getUserRegistrations(userId);
        return ResponseEntity.ok(registrations);
    }
}
