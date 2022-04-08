package com.example.DigitaleAnwesenheitsliste.Persons;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "dozent")
public class Dozent extends Person {

    @Id
    private Long id;

    @Column
    private String person_id;

}
