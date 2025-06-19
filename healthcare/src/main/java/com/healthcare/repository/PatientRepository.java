package com.healthcare.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entities.Patient;
import com.healthcare.entities.User;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByCreatedBy(User user);
}
