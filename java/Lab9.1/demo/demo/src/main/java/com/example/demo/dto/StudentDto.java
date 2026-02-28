package com.example.demo.dto;

import com.example.demo.model.EducationGroup;
import lombok.Data;

@Data
public class StudentDto
{
    private int id;
    private String name;
    private String surname;
    private EducationGroup educationGroup;
}
