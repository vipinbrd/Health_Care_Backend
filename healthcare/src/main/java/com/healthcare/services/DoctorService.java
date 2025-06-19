package com.healthcare.services;



import com.healthcare.dto.DoctorRequestDto;
import com.healthcare.dto.DoctorResponseDto;

import java.util.List;

public interface DoctorService {
    DoctorResponseDto createDoctor(DoctorRequestDto dto);
    List<DoctorResponseDto> getAllDoctors();
    DoctorResponseDto getDoctorById(Long id);
    DoctorResponseDto updateDoctor(Long id, DoctorRequestDto dto);
    void deleteDoctor(Long id);
}
