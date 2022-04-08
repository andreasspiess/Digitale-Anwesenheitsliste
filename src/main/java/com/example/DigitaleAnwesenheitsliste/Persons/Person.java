package com.example.DigitaleAnwesenheitsliste.Persons;

import org.springframework.security.core.authority.mapping.Attributes2GrantedAuthoritiesMapper;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

}