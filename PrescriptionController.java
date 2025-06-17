package com.smartclinic.controller;

import com.smartclinic.model.Prescription;
import com.smartclinic.service.PrescriptionService;
import com.smartclinic.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/add")
    public ResponseEntity<?> savePrescription(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody Prescription prescription) {

        if (!tokenService.isTokenValid(token)) {
            return ResponseEntity.status(401).body("Invalid or expired token.");
        }

        Prescription saved = prescriptionService.savePrescription(prescription);
        if (saved != null) {
            return ResponseEntity.ok("Prescription saved successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to save prescription.");
        }
    }
}
