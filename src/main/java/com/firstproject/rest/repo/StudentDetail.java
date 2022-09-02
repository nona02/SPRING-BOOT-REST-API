package com.firstproject.rest.repo;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class StudentDetail {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name ="NAME")
    private String name;

    @Column(name = "COLLEGE_NAME")
    private String collegeName;

    @Column(name = "AGE")
    private int age;

    public StudentDetail() {
    }

    public StudentDetail(String name, String collegeName, int age) {
        this.name = name;
        this.collegeName = collegeName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}