package com.example.DigitaleAnwesenheitsliste.Persons.repository;

import com.example.DigitaleAnwesenheitsliste.Persons.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepo extends JpaRepository<Presence, Long> {
}
