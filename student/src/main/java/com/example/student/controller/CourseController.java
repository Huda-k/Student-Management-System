package com.example.student.controller;


import com.example.student.entity.Course;
import com.example.student.repository.CourseRepo;
import com.example.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping("/saveCourse")
    public Course saveCourse(@RequestBody Course course) {
            return service.saveCourse(course);
    }

    @GetMapping("/courseList")
    public List<Course> getAllCourse() {
        return service.getAllCourse();
    }

    @GetMapping("/getCourseById/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int courseId) {
        return service.getCourseById(courseId).orElse(null);
    }

    @PutMapping("/updateCourse/{courseId}")
    public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course updateCourse) {
        return service.updateCourse(courseId, updateCourse);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public String deleteCourse(@PathVariable("courseId") int courseId) {
        service.deleteCourse(courseId);
        return "Deleted Successfully";
    }
}