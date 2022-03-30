package com.tectoro.ums.dao;

import com.tectoro.ums.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDao extends JpaRepository<Student, Integer> {
    void deleteByMarksLessThanEqual(Integer marks);
}
