package com.example.student.repository;

import com.example.student.entity.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRepo extends JpaRepository<BookIssue, Integer> {
}
