package com.grupp4.studentregistry;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

/*
Denna klass motsvarar funktionaliteten vi skulle få ut at StudentService-klassen
eftersom MongoRepository kommer med färdigkodad business logic.
*/

public interface StudentRepository extends MongoRepository <Student, String> {
    List<Student> findStudentByEmail(String email); //skapar här vår egen metod för att hitta via email

}
