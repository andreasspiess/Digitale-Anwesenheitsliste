package com.example.DigitaleAnwesenheitsliste.Persons;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Person {

    @Id
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

}
