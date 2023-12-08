package com.springboot.example.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Data Access Layer  
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



}
