package com.springboot.example.Student;
import jakarta.transaction.Transactional;
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

    public void deleteStudent (Long studentId) {
   boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
    throw new IllegalStateException("student with ID " + studentId+  " does not exist");

    } else {
        studentRepository.deleteById(studentId);
    }
    }
@Transactional
    public void updateStudent (Long studentId,String name, String email) {

Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id "+studentId+" does not exist"));

    if (name != null && name.length() > 0 && !student.getId().equals(name)) {
        student.setName(name);
    }

    if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {

        Optional <Student> studentOptional = studentRepository.findStudentByEmail(email);

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        student.setEmail(email);
    }




    }


}
