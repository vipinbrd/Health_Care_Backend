package com.healthcare.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.MappingRequestDto;
import com.healthcare.dto.MappingResponseDto;
import com.healthcare.services.MappingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mappings")
@RequiredArgsConstructor
public class MappingController {

    private final MappingService mappingService;

    @PostMapping
    public MappingResponseDto assignDoctor(@RequestBody MappingRequestDto dto) {
        return mappingService.assignDoctorToPatient(dto);
    }

    @GetMapping
    public List<MappingResponseDto> getAll() {
        return mappingService.getAllMappings();
    }

    @GetMapping("/{patientId}")
    public List<MappingResponseDto> getByPatient(@PathVariable Long patientId) {
        return mappingService.getMappingsByPatientId(patientId);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable Long id) {
        mappingService.deleteMapping(id);
    }
}
