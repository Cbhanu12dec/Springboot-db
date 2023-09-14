package com.mysqltech.app.springbootrestapidb.controller;

import com.mysqltech.app.springbootrestapidb.model.Student;
import com.mysqltech.app.springbootrestapidb.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student>  addStudent(@RequestBody Student student){
        return new ResponseEntity<>(this.studentService.addNewStudent(student), HttpStatus.CREATED);

    }

    //add student along with class

    @PostMapping("/{classId}/add")
    public ResponseEntity<Student> addStudentAlongWithClass(@PathVariable("classId") long classId, @RequestBody Student student){
        return new ResponseEntity<>(this.studentService.addStudentWithClass(classId, student), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Student>>  getAllStudentsInfo(){
        return new ResponseEntity<>(this.studentService.getAllStudents(), HttpStatus.OK);
    }
}
