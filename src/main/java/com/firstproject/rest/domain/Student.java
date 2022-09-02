package com.firstproject.rest.domain;

public class Student {
    private int id;
    private String name;
    private String collegeName;
    private int age;

    public Student() {
    }

    public Student(int id, String name, String collegeName, int age) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
