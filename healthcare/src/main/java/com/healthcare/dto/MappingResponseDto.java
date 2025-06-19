package com.healthcare.dto;

import lombok.Data;

@Data
public class MappingResponseDto {
    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
}

