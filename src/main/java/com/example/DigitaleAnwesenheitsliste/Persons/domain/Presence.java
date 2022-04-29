package com.example.DigitaleAnwesenheitsliste.Persons.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "anwesenheit")
public class Presence {

    @Id
    private Long id;

    @Column
    private String student_id;

    @Column
    private LocalDateTime datum;

    @Column
    private String presentAbsent;
}