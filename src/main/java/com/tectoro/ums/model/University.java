package com.tectoro.ums.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "universityEntity")
public class University{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String dept;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    private List<Student> studentList;

    /*public University() {
    }

    public University(Integer uid, String dept, List<Student> studentList) {
        this.uid = uid;
        this.dept = dept;
        this.studentList = studentList;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "University{" +
                "uid=" + uid +
                ", dept='" + dept + '\'' +
                ", studentList=" + studentList +
                '}';
    }*/
}
