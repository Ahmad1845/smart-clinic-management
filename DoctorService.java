package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Get doctor's available times
    public List<String> getAvailableTimes(int doctorId, LocalDate date) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor != null) {
            return doctor.getAvailableTimes();
        }
        return null;
    }

    // Validate login and return structured message
    public String validateDoctorLogin(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor != null && doctor.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    public Doctor getDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }
}
