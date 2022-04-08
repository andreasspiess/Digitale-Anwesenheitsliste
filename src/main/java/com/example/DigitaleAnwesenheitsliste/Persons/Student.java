package com.example.DigitaleAnwesenheitsliste.Persons;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "student")
public class Student extends Person {

    @Id
    private Long id;

    @Column
    private String person_id;

}
