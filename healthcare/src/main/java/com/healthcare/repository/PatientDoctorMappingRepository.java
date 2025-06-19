package com.healthcare.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entities.Patient;
import com.healthcare.entities.PatientDoctorMapping;

public interface PatientDoctorMappingRepository extends JpaRepository<PatientDoctorMapping, Long> {
    List<PatientDoctorMapping> findByPatient(Patient patient);
}
