package com.springboot.example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Restful API
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents()
    {
    return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudents(@RequestBody Student student) {
     studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent (@PathVariable("studentId") Long studentId) {studentService.deleteStudent(studentId); }

    @PutMapping
    public void updateStudent (@RequestBody Student student){
        System.out.println(student);
        studentService.updateStudent(student);
    }

}
