package com.example.DigitaleAnwesenheitsliste.Persons.repository;

import com.example.DigitaleAnwesenheitsliste.Persons.Dozent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DozentRepo extends JpaRepository<Dozent, Long> {
}
