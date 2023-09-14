package com.mysqltech.app.springbootrestapidb;

import com.mysqltech.app.springbootrestapidb.model.Teacher;
import com.mysqltech.app.springbootrestapidb.repository.TeacherRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherTest {

    @Autowired
    private TeacherRepository teacherRepository;

    private Teacher teacher;

    @BeforeEach
    public void setup(){
        this.teacher = Teacher.builder()
                .firstName("Bhanu")
                .lastName("cheryala")
                .role("prof")
                .build();
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveTeacherTest(){

        Teacher employee = Teacher.builder()
                .firstName("Bhanu")
                .lastName("Cheryala")
                .role("prof")
                .build();

        this.teacherRepository.save(employee);
        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

}
