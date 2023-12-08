package com.springboot.example.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        return args -> {
          Student robert = new Student( "Robert", LocalDate.of(2000, Month.FEBRUARY, 23), "Robert@hotmail.es");
          Student juan = new Student( "Juan", LocalDate.of(1980, Month.APRIL, 3), "Juan@outlook.co.uk");
        repository.saveAll(
                List.of(robert, juan)
        );
        };
    }

}
