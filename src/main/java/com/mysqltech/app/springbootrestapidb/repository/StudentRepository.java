package com.mysqltech.app.springbootrestapidb.repository;

import com.mysqltech.app.springbootrestapidb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
