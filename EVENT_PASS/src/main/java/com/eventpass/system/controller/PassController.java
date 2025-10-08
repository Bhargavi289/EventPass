package com.eventpass.system.controller;

import com.eventpass.system.model.Pass;
import com.eventpass.system.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passes")
@CrossOrigin(origins = "http://localhost:5173") // change if your frontend runs on a different port
public class PassController {

    @Autowired
    private PassService passService;

    // Create pass
    @PostMapping
    public ResponseEntity<Pass> createPass(@RequestBody Pass pass) {
        Pass savedPass = passService.createPass(pass);
        return ResponseEntity.ok(savedPass);
    }

    // Get all passes
    @GetMapping
    public ResponseEntity<List<Pass>> getAllPasses() {
        List<Pass> passes = passService.getAllPasses();
        return ResponseEntity.ok(passes);
    }

    // Get pass by registration ID
    @GetMapping("/registration/{id}")
    public ResponseEntity<Pass> getPassByRegistrationId(@PathVariable Long id) {
        Pass pass = passService.getPassByRegistrationId(id);
        return ResponseEntity.ok(pass);
    }

    // Update pass
    @PutMapping
    public ResponseEntity<Pass> updatePass(@RequestBody Pass pass) {
        Pass updatedPass = passService.updatePass(pass);
        return ResponseEntity.ok(updatedPass);
    }

    // Delete pass
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePass(@PathVariable Integer id) {
        passService.deletePass(id);
        return ResponseEntity.noContent().build();
    }
}
