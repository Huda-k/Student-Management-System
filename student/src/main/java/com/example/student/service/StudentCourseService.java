package com.example.student.service;


import com.example.student.entity.StudentCourse;
import com.example.student.entity.StudentCourse;
import com.example.student.repository.AddressRepo;
import com.example.student.repository.StudentCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {
    private final StudentCourseRepo studentCourseRepo;

    @Autowired
    public StudentCourseService(StudentCourseRepo studentCourseRepo) {
        this.studentCourseRepo = studentCourseRepo;
    }

    public List<StudentCourse> getAllStudentCourse() {
        return studentCourseRepo.findAll();
    }

    public Optional<StudentCourse> getStudentCourseById(int studentCourseId) {
        return studentCourseRepo.findById(studentCourseId);
    }


    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepo.save(studentCourse);
    }

    public StudentCourse updateStudentCourse(int studentCourseId, StudentCourse updatedStudentCourse) {
        Optional<StudentCourse> existingStudentCourse = studentCourseRepo.findById(studentCourseId);
        if (existingStudentCourse.isPresent()) {
            StudentCourse studentCourseToUpdate = existingStudentCourse.get();
            return studentCourseRepo.save(studentCourseToUpdate);
        } else {
            return null;
        }
    }

    public void deleteStudentCourse(int studentCourseId) {
        studentCourseRepo.deleteById(studentCourseId);
    }

}