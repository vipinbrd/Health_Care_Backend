package com.healthcare.services;
import java.util.List;

import com.healthcare.dto.PatientRequestDto;
import com.healthcare.dto.PatientResponseDto;

public interface PatientService {
    PatientResponseDto createPatient(PatientRequestDto dto, String userEmail);
    List<PatientResponseDto> getAllPatients(String userEmail);
    PatientResponseDto getPatientById(Long id);
    PatientResponseDto updatePatient(Long id, PatientRequestDto dto);
    void deletePatient(Long id);
}
