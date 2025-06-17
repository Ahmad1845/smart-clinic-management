package com.smartclinic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String specialization;

    @Lob
    private String availableTimes;

    // Getters and Setters

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(String availableTimes) {
        this.availableTimes = availableTimes;
    }
}
