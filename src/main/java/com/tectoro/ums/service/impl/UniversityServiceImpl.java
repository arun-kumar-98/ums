package com.tectoro.ums.service.impl;

import com.tectoro.ums.dao.IStudentDao;
import com.tectoro.ums.dao.IUniversityDao;
import com.tectoro.ums.model.Student;
import com.tectoro.ums.model.University;
import com.tectoro.ums.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UniversityServiceImpl implements IUniversityService {

    @Autowired
    private IUniversityDao dao;
    @Autowired
    private IStudentDao iStudentDao;


    /*
     * @purpose: save all entity record in dattabse that mapped with oneToMany Relational mapping
     *  @param:saveUniversity take parameter as entity object insert into db
     * @return: this method return an enitty of university as well internally insert student also
     * */

    @Override
    public University saveUniversity(University university) {
        return dao.save(university);
    }

    @Override
    public List<University> getUniversityStudent() {

        return dao.findAll();
    }
    /*
     * purpose: we will get details of student according to university dept
     *  @param: it will take string type dept
     * return:student records from specific deparment
     */

    @Override
    public List<University> findAllStudentByDepartment(String dept) {
        List<University> departmentList = dao.findByDept(dept);
        if (departmentList.isEmpty()) {
            throw null;
        }
        return departmentList;
    }

    @Override
    public List<Student> findAllStudentByLowMarks(String dept) {
        List<University> listOfDept = dao.findByDept(dept);
        List<Student> studentListOfLowMarks = new ArrayList<>();
        for (University item : listOfDept) {
            List<Student> studentLists = item.getStudentList();
            for (Student studentEntity : studentLists) {
                Student student = studentEntity;
                if (student.getMarks() < 40) {
                    studentListOfLowMarks.add(student);
                }
            }
        }
        return studentListOfLowMarks;


    }

    @Override
    public List<Student> findAllStudentOfHighPerformance() {
        List<University> universityList = dao.findAll();
        List<Student> studentListOfGreaterMarks = new ArrayList<>();
        for (University university : universityList) {
            List<Student> studentList1 = university.getStudentList();
            for (Student studentEntity : studentList1) {
                Student student = studentEntity;
                if (student.getMarks() > 60) {
                    student.setMarks(student.getMarks() + 10);
                    studentListOfGreaterMarks.add(student);
                }

            }


        }
        iStudentDao.saveAll(studentListOfGreaterMarks);

        return studentListOfGreaterMarks;
    }

    @Override
    public List<Student> findAllLowPerformingStudent() {
        List<University> universities = dao.findAll();
        List<Student> studentListOfLowPerformance = new ArrayList<>();

        for (University university : universities) {
            List<Student> students = university.getStudentList();
            for (Student studentEntity : students) {
                Student student = studentEntity;
                if (student.getMarks() < 40) {
                    studentListOfLowPerformance.add(student);
                }
            }

        }
        return studentListOfLowPerformance;
    }

    /*
     * no need to take find details from university
     * we can easily fetch less performing student by student repo.
     */
    @Override
    public String removePoorPerformanceStudent() {

        List<Student> studentList = iStudentDao.findAll();
        List<Student> removeStudentlist = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getMarks() <= 10) {
                removeStudentlist.add(student);
            }
            iStudentDao.deleteAll(removeStudentlist);
        }
        if (removeStudentlist == null)
            return "student removes from university";
        else
            return "student  are in university";
    }
        /*students.forEach(item -> {
            if (item.getMarks() <= 10){
                studentList.add(item);
            }
        });
        dao.deleteByStudentList(studentList);
        */


    @Override
    public List<Student> sortListOfStudentWithinDepartment(String dept) {
        List<University> universities = dao.findByDept(dept);
        List<Student> studentList = new ArrayList<>();
        for (University university : universities) {
            List<Student> students = university.getStudentList();
            for (Student student : students) {
                studentList.add(student);
            }
        }
        Collections.sort(studentList, Comparator.comparingInt(Student::getMarks));
        //List<Student> sortedList=sortedStudentList.sort();
        return studentList;
    }

    /*@Override
    public String removePoorPerformanceStudent() {
        //List<University> universityList = dao.findAll(); mistake here only
        List<Student> studentList = new ArrayList<>();
        studentList = iStudentDao.findAll();
        for (Student student : studentList) {
            if (student.getMarks() <= 10) {
                iStudentDao.delete(student);
                return "record deleted successfully of student:  ";
            }
        }
        return "no student less than 10 marks ";
    }*/
}