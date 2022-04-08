package com.example.DigitaleAnwesenheitsliste.Persons.repository;

import com.example.DigitaleAnwesenheitsliste.Persons.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
