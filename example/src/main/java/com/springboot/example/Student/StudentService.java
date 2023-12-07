package com.springboot.example.Student;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {


    public List<Student> getStudents()
    {
        return List.of(new Student(1L, "Robert", 21, LocalDate.of(2000, Month.FEBRUARY, 23), "Robert@hotmail.es"));
    }
}
