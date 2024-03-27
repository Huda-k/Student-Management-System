package com.example.student.service;


import com.example.student.entity.Course;
import com.example.student.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int courseId) {
        return courseRepo.findById(courseId);
    }

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course updateCourse(int courseId, Course updatedCourse) {
        Optional<Course> existingCourse = courseRepo.findById(courseId);
        if (existingCourse.isPresent()) {
            Course courseToUpdate = existingCourse.get();
            courseToUpdate.setCourseName(updatedCourse.getCourseName());
            courseToUpdate.setDescription(updatedCourse.getDescription());
            return courseRepo.save(courseToUpdate);
        } else {
            return null;
        }
    }

    public void deleteCourse(int courseId) {
        courseRepo.deleteById(courseId);
    }

}