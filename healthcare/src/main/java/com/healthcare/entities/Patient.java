package com.healthcare.entities;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String gender;

    private String disease;

    @ManyToOne
    @JoinColumn(name = "created_by") // the user who created this patient
    private User createdBy;
}
