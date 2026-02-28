package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Students")
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService service;

    public List<StudentDto> getAllStudents()
    {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(Long id)
    {
        return service.getStudentById(id);
    }


    @DeleteMapping("/{id}")
    public void  deleteStudentById(Long id)
    {
        service.deleteById(id);
    }





}
