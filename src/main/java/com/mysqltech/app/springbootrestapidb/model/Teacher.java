package com.mysqltech.app.springbootrestapidb.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "teachers")
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="role")
    private String role;
}
