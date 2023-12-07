package com.springboot.example;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.springboot.example.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);

	}
	@GetMapping
	public List<Student> hello()
	{
		return List.of(new Student(1L, "Robert", 21, LocalDate.of(2000, Month.FEBRUARY, 23), "Robert@hotmail.es"));
	}

}
