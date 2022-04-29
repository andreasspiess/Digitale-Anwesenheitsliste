package com.example.DigitaleAnwesenheitsliste.Persons.repo;

import com.example.DigitaleAnwesenheitsliste.Persons.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String email);

    Optional<User> findByUsernameIs(String email);
}