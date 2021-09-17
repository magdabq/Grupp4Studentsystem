package com.grupp4.studentregistry.service;
//när man skapar Service så skapar man först ett interface
import com.grupp4.studentregistry.pojo.Student;

import java.util.List;

public interface StudentService {
    public abstract void createStudent(Student student);

    public abstract void updateStudentById(int id, Student student);

    public abstract String readAllStudent();

    public abstract String readStudentById(int id);

    public abstract void deleteStudent(int id);

}
