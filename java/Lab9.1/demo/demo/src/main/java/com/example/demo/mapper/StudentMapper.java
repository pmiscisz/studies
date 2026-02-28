package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper
{

    public StudentDto toDto(Student entity)
    {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEducationGroup(entity.getEducationGroup());
        return dto;
    }


    public  Student fromDto(StudentDto dto)
    {
        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEducationGroup(dto.getEducationGroup());
        return entity;
    }



}
