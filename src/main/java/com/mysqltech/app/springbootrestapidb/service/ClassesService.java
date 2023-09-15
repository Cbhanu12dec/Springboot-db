package com.mysqltech.app.springbootrestapidb.service;

import com.mysqltech.app.springbootrestapidb.model.Classes;

import java.util.List;
import java.util.UUID;

public interface ClassesService {

    Classes addClass(Classes classes, UUID id);

    List<Classes> getAllCLassesOfTeacher(UUID id);

    List<Classes> getAllClasses();

    Classes updateClass(UUID classId, Classes classRequest);



}
