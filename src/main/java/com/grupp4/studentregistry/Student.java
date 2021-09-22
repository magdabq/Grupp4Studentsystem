package com.grupp4.studentregistry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Data //lombok annotation som ger getters,setters, constructor, ToString
@Document //spring annotation som gör att mongo db vet att detta är en post i databasen

public class Student {
    @Id //spring
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true) //email ska vara unikt
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favoriteSubjects;
    private LocalDateTime created;

    //constructor utan id. för att id ska kunna autogenereras
    public Student(String firstName, String lastName,
                   String email, Gender gender, Address address,
                   List<String> favoriteSubjects,
                   LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favoriteSubjects = favoriteSubjects;
        this.created = created;
    }
}