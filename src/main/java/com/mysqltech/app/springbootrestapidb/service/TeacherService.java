package com.mysqltech.app.springbootrestapidb.service;

import com.mysqltech.app.springbootrestapidb.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();
}
