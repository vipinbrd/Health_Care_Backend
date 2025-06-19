package com.healthcare.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.PatientRequestDto;
import com.healthcare.dto.PatientResponseDto;
import com.healthcare.services.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientResponseDto create(@RequestBody PatientRequestDto dto, Principal principal) {
        return patientService.createPatient(dto, principal.getName());
    }

    @GetMapping
    public List<PatientResponseDto> getAll(Principal principal) {
        return patientService.getAllPatients(principal.getName());
    }

    @GetMapping("/{id}")
    public PatientResponseDto getById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public PatientResponseDto update(@PathVariable Long id, @RequestBody PatientRequestDto dto) {
        return patientService.updatePatient(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
