package com.mysqltech.app.springbootrestapidb.repository;

import com.mysqltech.app.springbootrestapidb.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClassesRepository extends JpaRepository<Classes, UUID> {
    List<Classes> findByTeacherId(UUID id);
}
