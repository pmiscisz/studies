package com.example.demo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Student {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String surname;
    private double averageGrade;
    public Student() {
    }
    public Student(int id, String name, String surname, double
            averageGrade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.averageGrade = averageGrade;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id = " + id +
                ", name = " + name +
                ", surname = " + surname +
                ", averageGrade = " + averageGrade +
                "}";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public double getAverageGrade() {
        return averageGrade;
    }
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}