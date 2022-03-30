package com.tectoro.ums.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stdEntity")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdId;
    private String stdName;
    private Integer age;
    private Integer marks;


   /* public Student() {
    }

    public Student(Integer stdId, String stdName, Integer age, Integer marks) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.age = age;
        this.marks = marks;

    }

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdId=" + stdId +
                ", stdName='" + stdName + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }*/
}
