package com.mysqltech.app.springbootrestapidb.service.impl;

import com.mysqltech.app.springbootrestapidb.model.Teacher;
import com.mysqltech.app.springbootrestapidb.repository.TeacherRepository;
import com.mysqltech.app.springbootrestapidb.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher addTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }
}
