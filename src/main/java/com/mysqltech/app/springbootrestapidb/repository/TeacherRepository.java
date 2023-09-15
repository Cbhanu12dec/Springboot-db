package com.mysqltech.app.springbootrestapidb.repository;

import com.mysqltech.app.springbootrestapidb.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
