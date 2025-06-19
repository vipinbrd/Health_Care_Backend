package com.healthcare.services;



import com.healthcare.dto.MappingRequestDto;
import com.healthcare.dto.MappingResponseDto;

import java.util.List;

public interface MappingService {
    MappingResponseDto assignDoctorToPatient(MappingRequestDto dto);
    List<MappingResponseDto> getAllMappings();
    List<MappingResponseDto> getMappingsByPatientId(Long patientId);
    void deleteMapping(Long mappingId);
}