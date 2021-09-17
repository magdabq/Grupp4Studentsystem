package com.grupp4.studentregistry.pojo;

import lombok.*;
//Skapar en pojo
import java.time.LocalDate;
//Vi använder Lombok annotationer för att slippa skriva kod för Getters, Setters, Constructors

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //lägger till denna för framtida behov
public class Student {

    private String firstName;
    private String lastName;
    private int id;
    private String [] courses;
    private String mail;
    private LocalDate dateOfBirth;
    private boolean active; //om man är en aktiv student eller ej

    //skapar en constructor utan id den andra constructorn
    public Student(String firstName, String lastName, String[] courses, String mail, LocalDate dateOfBirth, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
        this.mail = mail;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
    }
}
