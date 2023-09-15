package com.mysqltech.app.springbootrestapidb.service.impl;

import com.mysqltech.app.springbootrestapidb.exception.ResourceNotFoundException;
import com.mysqltech.app.springbootrestapidb.model.Classes;
import com.mysqltech.app.springbootrestapidb.repository.ClassesRepository;
import com.mysqltech.app.springbootrestapidb.repository.TeacherRepository;
import com.mysqltech.app.springbootrestapidb.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository classesRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    public ClassesServiceImpl(ClassesRepository classesRepository) {
        super();
        this.classesRepository = classesRepository;
    }


    @Override
    public Classes addClass(Classes classes, UUID id) {
        Classes toReturn = teacherRepository.findById(id).map((teacher -> {
            classes.setTeacher(teacher);
            return this.classesRepository.save(classes);
        })).orElseThrow(()-> new ResourceNotFoundException("CLASS", "Id", classes.getTeacher().getId()));
        return toReturn;
    }

    @Override
    public List<Classes> getAllCLassesOfTeacher(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Classes","Not found Tutorial with id = " , id);
        }
        List<Classes> classes = classesRepository.findByTeacherId(id);
        return classes;
    }

    @Override
    public List<Classes> getAllClasses() {
        return this.classesRepository.findAll();
    }

    @Override
    public Classes updateClass(UUID classId, Classes classRequest) {
        Classes classes = classesRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException( "CLASS","Class id not found ",classId));

        classes.setStudent(classRequest.getStudent());
        classes.setRoomNumber(classRequest.getRoomNumber());
        classes.setPeriod(classRequest.getSubject());
        classes.setTeacher(classRequest.getTeacher());
        return classesRepository.save(classes);
    }


}
