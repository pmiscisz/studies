package com.example.demo.service;


import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    StudentRepository studentRepository;
    StudentMapper mapper;

    public List<StudentDto> getAllStudents()
    {
        List<StudentDto> students = studentRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toUnmodifiableList());
        return  students;
    }

    public StudentDto getStudentById(Long id)
    {
        StudentDto student = studentRepository.findById(id).map(mapper::toDto).orElseThrow();
        return student;
    }

    public void  deleteById(Long id)
    {
        studentRepository.deleteById(id);
    }



}
