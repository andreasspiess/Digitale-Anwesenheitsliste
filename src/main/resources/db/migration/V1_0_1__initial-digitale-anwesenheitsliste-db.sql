CREATE TABLE person (
                        id BIGSERIAL PRIMARY KEY,
                        firstName VARCHAR NOT NULL,
                        lastName VARCHAR NOT NULL,
                        email VARCHAR NOT NULL,
                        password VARCHAR NOT NULL);

CREATE TABLE dozent (
                        id BIGINT PRIMARY KEY,
                        CONSTRAINT FK_dozent_person FOREIGN KEY (id) REFERENCES person(id));

CREATE TABLE student (
                        id BIGINT PRIMARY KEY,
                        CONSTRAINT FK_student_person FOREIGN KEY (id) REFERENCES person(id));

CREATE TABLE anwesenheit (
                        id BIGSERIAL PRIMARY KEY,
                        student_id BIGINT NOT NULL,
                        datum TIMESTAMP NOT NULL,
                        presentAbsent VARCHAR NOT NULL,
                        CONSTRAINT FK_anwesenheit_student FOREIGN KEY (id) REFERENCES student(id));
