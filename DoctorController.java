package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import com.smartclinic.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestParam String email,
            @RequestHeader("Authorization") String token) {

        if (!tokenService.isTokenValid(token)) {
            return ResponseEntity.status(401).body("Invalid or expired token.");
        }

        Doctor doctor = doctorService.getDoctorByEmail(email);
        if (doctor == null) {
            return ResponseEntity.status(404).body("Doctor not found.");
        }

        return ResponseEntity.ok("Available Times: " + doctor.getAvailableTimes());
    }
}
