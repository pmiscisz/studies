package com.example.demo.repository;

import com.example.demo.model.EducationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationGroupRepository extends JpaRepository<EducationGroup,Long>
{
    Optional<EducationGroup> findById(Long id);
    void deleteById(long id);



}
