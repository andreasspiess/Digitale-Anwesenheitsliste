package com.example.DigitaleAnwesenheitsliste.Persons.repository;

import com.example.DigitaleAnwesenheitsliste.Persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
