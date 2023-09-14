package com.mysqltech.app.springbootrestapidb.repository;

import com.mysqltech.app.springbootrestapidb.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepository extends JpaRepository<Classes, Long> {
}
