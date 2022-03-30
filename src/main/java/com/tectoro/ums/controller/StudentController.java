package com.tectoro.ums.controller;

import com.tectoro.ums.model.Student;
import com.tectoro.ums.model.University;
import com.tectoro.ums.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/university")
public class StudentController {

    @Autowired
    private IUniversityService service;

    @PostMapping("/save")
    public ResponseEntity<University> entitySave(@RequestBody University university) {
        return ResponseEntity.ok(service.saveUniversity(university));
    }

    @GetMapping("/get")
    public ResponseEntity<List<University>> getUniversity() {
        return ResponseEntity.ok(service.getUniversityStudent());
    }

    @GetMapping("/get/{dept}")
    public ResponseEntity<List<University>> getOneStudent(@PathVariable String dept) {
        return ResponseEntity.ok(service.findAllStudentByDepartment(dept));
    }

    @GetMapping("/marks/{dept}")
    public ResponseEntity<List<Student>> getStudentByLowMarks(@PathVariable String dept) {
        return ResponseEntity.ok(service.findAllStudentByLowMarks(dept));
    }

    @GetMapping("/bonus_marks")
    public ResponseEntity<List<Student>> studentBonusMarks() {
        return ResponseEntity.ok(service.findAllStudentOfHighPerformance());

    }

    @GetMapping("/low_performance")
    public ResponseEntity<List<Student>> lowPerformingStudents() {
        return ResponseEntity.ok(service.findAllLowPerformingStudent());
    }


    @GetMapping("/sort_by_marks/{dept}")
    public ResponseEntity<List<Student>> sortWithinDepartment(@PathVariable String dept) {
        return ResponseEntity.ok(service.sortListOfStudentWithinDepartment(dept));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLessMarks() {
        return ResponseEntity.ok(service.removePoorPerformanceStudent());
    }


}

