package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Retrieve by email
    Optional<Patient> findByEmail(String email);

    // Retrieve by email or phone
    Optional<Patient> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
