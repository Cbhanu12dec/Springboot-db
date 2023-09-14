package com.mysqltech.app.springbootrestapidb.service;

import com.mysqltech.app.springbootrestapidb.model.Student;

import java.util.List;

public interface StudentService {

    Student addNewStudent(Student student);

    List<Student> getAllStudents();

    Student addStudentWithClass(long classId, Student student);

}
