package com.tectoro.ums.dao;

import com.tectoro.ums.model.Student;
import com.tectoro.ums.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUniversityDao extends JpaRepository<University, Integer> {

    /*@Query(value = "select  u from  std_entity u where u.dept like '%=:?dept%'")
    List<Student> getByDept(@Param("dept") String dept);*/


    List<University> findByDept(String dept);

   // List<Student> deleteByStudentList(List<Student> item);
}
