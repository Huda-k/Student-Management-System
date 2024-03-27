package com.example.student.controller;


import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/studentList")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping("/getStudentById/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return service.getStudentById(studentId).orElse(null);
    }

    @PutMapping("/updateStudent/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student updateStudent) {
        return service.updateStudent(studentId, updateStudent);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        service.deleteStudent(studentId);
        return "Deleted Successfully";
    }
}
