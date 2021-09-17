package com.grupp4.studentregistry.service;
// funktionaliteten ligger här i appen. Denna klass implementerar interface


import com.grupp4.studentregistry.pojo.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private List<Student> studentList = new ArrayList<>();

    static{
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setFirstName("Kalle");
        student1.setLastName("Karlsson");
        student1.setId(1);
        student1.setCourses(new String []{"Mathematics", "Physics", "Database"});
        student1.setDateOfBirth(LocalDate.of(1985,8,1));
        student1.setMail("kalle.k@k.se");
        student1.setActive(true);

        student2.setFirstName("Marian");
        student2.setLastName("Ek");
        student2.setId(2);
        student2.setCourses(new String []{"Swedish", "Physics", "Database"});
        student2.setDateOfBirth(LocalDate.of(1981,2,1));
        student2.setMail("marian@k.se");
        student2.setActive(false);

    }

    @Override
    public void createStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public List<Student> readAllStudent() {
        return null;
    }

    @Override
    public Student readStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudent(int id) {

    }

}
