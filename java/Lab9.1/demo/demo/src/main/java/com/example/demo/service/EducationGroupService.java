package com.example.demo.service;

import com.example.demo.dto.EducationGroupDto;
import com.example.demo.mapper.EducationGroupMapper;
import com.example.demo.model.EducationGroup;
import com.example.demo.repository.EducationGroupRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationGroupService
{

    EducationGroupRepository educationGroupRepository;
    EducationGroupMapper mapper;

   EducationGroupDto findById(Long id)
    {
        return educationGroupRepository.findById(id).map(mapper::toDto).orElse(null);
    }


    void deleteById(long id)
    {
        educationGroupRepository.deleteById(id);
    }





}
