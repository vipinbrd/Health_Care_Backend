package com.healthcare.serviceImpl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthcare.dto.MappingRequestDto;
import com.healthcare.dto.MappingResponseDto;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.PatientDoctorMapping;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientDoctorMappingRepository;
import com.healthcare.repository.PatientRepository;
import com.healthcare.services.MappingService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MappingServiceImpl implements MappingService {

    private final PatientDoctorMappingRepository mappingRepo;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;

    @Override
    public MappingResponseDto assignDoctorToPatient(MappingRequestDto dto) {
        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        Doctor doctor = doctorRepo.findById(dto.getDoctorId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

        PatientDoctorMapping mapping = new PatientDoctorMapping();
        mapping.setPatient(patient);
        mapping.setDoctor(doctor);

        return mapToDto(mappingRepo.save(mapping));
    }

    @Override
    public List<MappingResponseDto> getAllMappings() {
        return mappingRepo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<MappingResponseDto> getMappingsByPatientId(Long patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        return mappingRepo.findByPatient(patient)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteMapping(Long id) {
        if (!mappingRepo.existsById(id)) {
            throw new EntityNotFoundException("Mapping not found");
        }
        mappingRepo.deleteById(id);
    }

    private MappingResponseDto mapToDto(PatientDoctorMapping mapping) {
        MappingResponseDto dto = new MappingResponseDto();
        dto.setId(mapping.getId());
        dto.setPatientId(mapping.getPatient().getId());
        dto.setPatientName(mapping.getPatient().getName());
        dto.setDoctorId(mapping.getDoctor().getId());
        dto.setDoctorName(mapping.getDoctor().getName());
        return dto;
    }
}
