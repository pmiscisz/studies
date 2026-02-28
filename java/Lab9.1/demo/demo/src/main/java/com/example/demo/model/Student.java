package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"educationGroup"})
public class Student
{

    @GeneratedValue
    @Id
    private int id;

    private String name;

    private String surname;

    @OneToOne
    @JoinColumn(name = "education_group_id")
    private EducationGroup educationGroup;


}
