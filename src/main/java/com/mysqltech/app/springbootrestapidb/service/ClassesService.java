package com.mysqltech.app.springbootrestapidb.service;

import com.mysqltech.app.springbootrestapidb.model.Classes;

import java.util.List;

public interface ClassesService {

    Classes addClass(Classes classes, long id);

    List<Classes> getAllClasses();

    Classes addStudentToClass(long classId, long studentId);
}
