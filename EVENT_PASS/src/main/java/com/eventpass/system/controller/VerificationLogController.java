package com.eventpass.system.controller;

import com.eventpass.system.model.VerificationLog;
import com.eventpass.system.service.VerificationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "http://localhost:5173") // adjust to your frontend URL/port
public class VerificationLogController {

    @Autowired
    private VerificationLogService logService;

    // Create a new verification log
    @PostMapping
    public ResponseEntity<VerificationLog> createLog(@RequestBody VerificationLog log) {
        VerificationLog createdLog = logService.createLog(log);
        return ResponseEntity.ok(createdLog);
    }

    // Get all logs
    @GetMapping
    public ResponseEntity<List<VerificationLog>> getAllLogs() {
        List<VerificationLog> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    // Delete a log by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Integer id) {
        logService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
