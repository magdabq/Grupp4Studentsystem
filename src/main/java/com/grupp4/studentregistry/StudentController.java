package com.grupp4.studentregistry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//här sker kontakten utåt med endpoint
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = new ArrayList<Student>();
            studentRepository.findAll().forEach(students::add);
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) {
        Optional<Student> studentData = studentRepository.findById(id);
        if (studentData.isPresent()){
           return new ResponseEntity<>(studentData.get(), HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) { //RequestBody tar ett helt json-objekt
        try {
            Student studentnew = studentRepository.save(new Student(student.getFirstName(),
                    student.getLastName(),student.getEmail(), student.getGender(),
                    student.getAddress(), student.getFavoriteSubjects(), LocalDateTime.now()));
            return new ResponseEntity<>(studentnew, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        Optional<Student> studentData = studentRepository.findById(id);
        if (studentData.isPresent()){
            Student studentupdate = studentData.get();
            studentupdate.setFirstName(student.getFirstName());//getFirstName tas från requestbody dvs det som kommer från användaren via HTTP.
            studentupdate.setLastName(student.getLastName());
            studentupdate.setEmail(student.getEmail());
            studentupdate.setGender(student.getGender());
            studentupdate.setAddress(student.getAddress());
            studentupdate.setFavoriteSubjects(student.getFavoriteSubjects());

            return new ResponseEntity<>(studentRepository.save(studentupdate),HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") String id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students")
    public ResponseEntity<HttpStatus> deleteAllStudents() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/{email}")
    public ResponseEntity<List<Student>> findByEmail(@PathVariable("email")String email) {
        try {
            List<Student> students = studentRepository.findStudentByEmail(email);
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
