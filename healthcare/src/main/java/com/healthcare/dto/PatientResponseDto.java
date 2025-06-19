package com.healthcare.dto;



import lombok.Data;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String createdBy; 
}
