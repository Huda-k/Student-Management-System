package com.example.student.controller;


import com.example.student.entity.Student;
import com.example.student.entity.StudentCourse;
import com.example.student.repository.StudentCourseRepo;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentCourseService;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCourseController {
    @Autowired
    private StudentCourseService service;

    @PostMapping("/saveStudentCourse")
    public StudentCourse saveStudentCourse(@RequestBody StudentCourse studentCourse) {
        return service.saveStudentCourse(studentCourse);
    }

    @GetMapping("/studentCourseList")
    public List<StudentCourse> getAllStudentCourse() {
        return service.getAllStudentCourse();
    }

    @GetMapping("/getStudentCourseById/{studentCourseId}")
    public StudentCourse getStudentCourseById(@PathVariable("studentCourseId") int studentCourseId) {
        return service.getStudentCourseById(studentCourseId).orElse(null);
    }

    @PutMapping("/updateStudentCourse/{studentCourseId}")
    public StudentCourse updateStudentCourse(@PathVariable("studentCourseId") int studentCourseId, @RequestBody StudentCourse updateStudentCourse) {
        return service.updateStudentCourse(studentCourseId, updateStudentCourse);
    }

    @DeleteMapping("/deleteStudentCourse/{studentCourseId}")
    public String deleteStudentCourse(@PathVariable("studentCourseId") int studentCourseId) {
        service.deleteStudentCourse(studentCourseId);
        return "Deleted Successfully";
    }
}