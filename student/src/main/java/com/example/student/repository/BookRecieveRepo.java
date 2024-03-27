package com.example.student.repository;

import com.example.student.entity.BookRecieve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRecieveRepo extends JpaRepository<BookRecieve, Integer> {
}
