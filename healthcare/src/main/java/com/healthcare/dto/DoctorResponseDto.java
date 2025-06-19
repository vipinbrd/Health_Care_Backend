package com.healthcare.dto;



import lombok.Data;

@Data
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phone;
}
