package com.mysqltech.app.springbootrestapidb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="CLASSES")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="ID")
    private UUID id;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "SUBJECT")
    private String subject;

    @Column(name="PERIOD")
    private String period;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "STUDENT_CLASSES",
            joinColumns = { @JoinColumn(name = "CLASS_ID") },
            inverseJoinColumns = { @JoinColumn(name = "STUDENT_ID") })
    private Set<Student> student = new HashSet<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public void removeStudent(UUID studentId) {
        Student student1 = this.student.stream().filter(t -> t.getId() == studentId).findFirst().orElse(null);
        if (student1 != null) {
            this.student.remove(student1);
            student1.getClasses().remove(this);
        }
    }
}
