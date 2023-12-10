package com.springboot.example.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
//Service Layer
@Service
public class StudentService {

    StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
     this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
        //List.of(new Student(1L, "Robert", 21, LocalDate.of(2000, Month.FEBRUARY, 23), "Robert@hotmail.es"));
    }

    public void addNewStudent (Student student) {
        System.out.println(student);
    }
}
