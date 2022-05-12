package com.example.DigitaleAnwesenheitsliste.repo;

import com.example.DigitaleAnwesenheitsliste.domain.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence, Long> {


}
