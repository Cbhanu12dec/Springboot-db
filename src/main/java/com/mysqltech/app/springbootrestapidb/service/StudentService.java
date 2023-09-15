package com.mysqltech.app.springbootrestapidb.service;

import com.mysqltech.app.springbootrestapidb.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    Student addNewStudent(Student student);

    List<Student> getAllStudents();

    Student addStudentWithClass(UUID classId, Student student);

}
