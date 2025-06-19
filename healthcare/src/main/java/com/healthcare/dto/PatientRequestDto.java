package com.healthcare.dto;



import lombok.Data;

@Data
public class PatientRequestDto {
    private String name;
    private int age;
    private String gender;
    private String disease;
}
