package com.mysqltech.app.springbootrestapidb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "className")
    private String className;

    @Column(name="period")
    private String period;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacherId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "Student_classes",
            joinColumns = { @JoinColumn(name = "class_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private Set<Student> student = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public void addStudent(Student student) {
        this.student.add(student);
        student.getClasses().add(this);
    }

    public void removeStudent(long studentId) {
        Student student1 = this.student.stream().filter(t -> t.getId() == studentId).findFirst().orElse(null);
        if (student1 != null) {
            this.student.remove(student1);
            student1.getClasses().remove(this);
        }
    }
}
