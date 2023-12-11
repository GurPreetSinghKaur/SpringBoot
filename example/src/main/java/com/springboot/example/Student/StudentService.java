package com.springboot.example.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if ( studentOptional.isPresent()) {
            throw new IllegalStateException ("Email is already taken");
        }

        studentRepository.save(student);
    }


}
