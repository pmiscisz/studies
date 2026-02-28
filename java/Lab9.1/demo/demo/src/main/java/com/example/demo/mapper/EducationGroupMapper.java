package com.example.demo.mapper;

import com.example.demo.dto.EducationGroupDto;
import com.example.demo.model.EducationGroup;
import org.springframework.stereotype.Component;

@Component
public class EducationGroupMapper
{

    public EducationGroupDto toDto(EducationGroup entity)
    {
        EducationGroupDto dto = new EducationGroupDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public EducationGroup toEntity(EducationGroupDto dto)
    {
        EducationGroup entity = new EducationGroup();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

}
