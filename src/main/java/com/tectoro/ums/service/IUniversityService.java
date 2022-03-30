package com.tectoro.ums.service;

import com.tectoro.ums.model.Student;
import com.tectoro.ums.model.University;

import java.util.List;

public interface IUniversityService {
    University saveUniversity(University university);

    List<University> getUniversityStudent();

    List<University> findAllStudentByDepartment(String dept);

    List<Student> findAllStudentByLowMarks(String dept);

    List<Student> findAllStudentOfHighPerformance();

    List<Student> findAllLowPerformingStudent();

    String removePoorPerformanceStudent();

    List<Student> sortListOfStudentWithinDepartment(String dept);


}

