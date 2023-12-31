package com.mysqltech.app.springbootrestapidb.controller;

import com.mysqltech.app.springbootrestapidb.model.Teacher;
import com.mysqltech.app.springbootrestapidb.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        super();
        this.teacherService = teacherService;
    }

    @PostMapping()
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(this.teacherService.addTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(this.teacherService.getAllTeachers(), HttpStatus.OK);
    }
}
