package com.mysqltech.app.springbootrestapidb.controller;


import com.mysqltech.app.springbootrestapidb.model.Classes;
import com.mysqltech.app.springbootrestapidb.model.Student;
import com.mysqltech.app.springbootrestapidb.model.Teacher;
import com.mysqltech.app.springbootrestapidb.repository.TeacherRepository;
import com.mysqltech.app.springbootrestapidb.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/class")
public class ClassesController {

    private ClassesService classesService;
    @Autowired


    public ClassesController(ClassesService classesService) {
        super();
        this.classesService = classesService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Classes> addClass(@RequestBody Classes classes ,@PathVariable("id") long id){
        return new ResponseEntity<Classes>(this.classesService.addClass(classes, id), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Classes>> getAllClasses(){
        return new ResponseEntity<>(this.classesService.getAllClasses(), HttpStatus.OK);
    }

    // add students to class

    // /api/class/:classID/student/:studentID
    @PostMapping("/:classID/student/:studentID")
    public ResponseEntity<Classes> addClassToStudent(@PathVariable("classID") long classID, @PathVariable("studentID") long studentID){
        return new ResponseEntity<Classes>(this.classesService.addStudentToClass(classID, studentID), HttpStatus.CREATED);
    }


}
