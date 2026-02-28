package com.example.lab8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Student> getAll(){
        return jdbcTemplate.query("SELECT id, name, surname, averageGrade", BeanPropertyRowMapper.newInstance(Student.class));
    }
}

