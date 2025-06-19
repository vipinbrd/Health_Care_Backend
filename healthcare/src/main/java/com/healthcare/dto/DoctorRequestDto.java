package com.healthcare.dto;



import lombok.Data;

@Data
public class DoctorRequestDto {
    private String name;
    private String specialization;
    private String email;
    private String phone;
}
