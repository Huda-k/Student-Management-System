package com.example.student.service;


import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(int studentId) {
        return studentRepo.findById(studentId);
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(int studentId, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepo.findById(studentId);
        if (existingStudent.isPresent()) {
            Student studentToUpdate = existingStudent.get();
            studentToUpdate.setFirstName(updatedStudent.getFirstName());
            studentToUpdate.setLastName(updatedStudent.getLastName());
            studentToUpdate.setDateOfBirth(updatedStudent.getDateOfBirth());
            studentToUpdate.setContactInformation(updatedStudent.getContactInformation());
            studentToUpdate.setDateOfBirth(updatedStudent.getDateOfBirth());

            return studentRepo.save(studentToUpdate);
        } else {
            return null;
        }
    }

    public void deleteStudent(int studentId) {
        studentRepo.deleteById(studentId);
    }

}