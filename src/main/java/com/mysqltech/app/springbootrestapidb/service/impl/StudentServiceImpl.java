package com.mysqltech.app.springbootrestapidb.service.impl;

import com.mysqltech.app.springbootrestapidb.exception.ResourceNotFoundException;
import com.mysqltech.app.springbootrestapidb.model.Classes;
import com.mysqltech.app.springbootrestapidb.model.Student;
import com.mysqltech.app.springbootrestapidb.repository.ClassesRepository;
import com.mysqltech.app.springbootrestapidb.repository.StudentRepository;
import com.mysqltech.app.springbootrestapidb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    private ClassesRepository classesRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudentWithClass(long classId, Student student) {
        Student modifiedStudent = classesRepository.findById(classId).map((classes -> {
            long studentID = student.getId();

            if(studentID != 0L){
                Student updatedStudent = studentRepository.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", studentID));
                classes.addStudent(updatedStudent);
                classesRepository.save(classes);
                return updatedStudent;
            }
            classes.addStudent(student);
            return studentRepository.save(student);

        })).orElseThrow(()-> new ResourceNotFoundException("Student", "id",classId));

        return modifiedStudent;
    }
}
