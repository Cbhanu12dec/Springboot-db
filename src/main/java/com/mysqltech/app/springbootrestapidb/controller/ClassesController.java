package com.mysqltech.app.springbootrestapidb.controller;


import com.mysqltech.app.springbootrestapidb.model.Classes;
import com.mysqltech.app.springbootrestapidb.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/class")
public class ClassesController {

    private ClassesService classesService;
    @Autowired


    public ClassesController(ClassesService classesService) {
        super();
        this.classesService = classesService;
    }


    /*
            ADD CLASS WITH TEACHER ID AS CLASS WILL EXSISTS WITH TEACHER
     */
    @PostMapping("/{id}")
    public ResponseEntity<Classes> addClass(@RequestBody Classes classes ,@PathVariable("id") UUID id){
        return new ResponseEntity<Classes>(this.classesService.addClass(classes, id), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Classes>> getAllClasses(){
        return new ResponseEntity<>(this.classesService.getAllClasses(), HttpStatus.OK);
    }


    /*

            GET ALL CLASSES OF SPECIFIC TEACHER
     */

    @GetMapping("/{teacherId}/classes")
    public ResponseEntity<List<Classes>> getAllClassesByTeacherId(@PathVariable(value = "teacherId") UUID teacherId) {
        return new ResponseEntity<>(this.classesService.getAllCLassesOfTeacher(teacherId), HttpStatus.OK);
    }


    /*

               Update a comment by id
               API:  PUT /api/comments/:id
     */

    @PutMapping("/{id}")
    public ResponseEntity<Classes> updateClasses(@PathVariable("id") UUID id, @RequestBody Classes classesRequest) {
        return new ResponseEntity<>(this.classesService.updateClass(id, classesRequest), HttpStatus.OK);
    }


}
