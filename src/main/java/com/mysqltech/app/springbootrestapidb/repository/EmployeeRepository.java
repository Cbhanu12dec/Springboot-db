package com.mysqltech.app.springbootrestapidb.repository;

import com.mysqltech.app.springbootrestapidb.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
