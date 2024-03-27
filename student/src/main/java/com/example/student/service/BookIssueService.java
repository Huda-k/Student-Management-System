package com.example.student.service;

import com.example.student.entity.BookIssue;
import com.example.student.entity.BookRecieve;
import com.example.student.repository.BookIssueRepo;
import com.example.student.repository.BookRecieveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookIssueService {
    private final BookIssueRepo bookIssueRepo;

    @Autowired
    public BookIssueService(BookIssueRepo bookIssueRepo) {
        this.bookIssueRepo = bookIssueRepo;
    }


    public List<BookIssue> getAllBookIssue() {
        return bookIssueRepo.findAll();
    }


    public Optional<BookIssue> getBookIssueById(int issueId) {
        return bookIssueRepo.findById(issueId);
    }

    public BookIssue saveBookIssue(BookIssue bookIssue) {
        return bookIssueRepo.save(bookIssue);
    }

    public BookIssue updateBookIssue(int issueId, BookIssue updatedBookIssue) {
        Optional<BookIssue> existingBookIssue = bookIssueRepo.findById(issueId);
        if (existingBookIssue.isPresent()) {
            BookIssue bookIssueToUpdate = existingBookIssue.get();
            bookIssueToUpdate.setIssueDate(updatedBookIssue.getIssueDate());
            bookIssueToUpdate.setDueDate(updatedBookIssue.getDueDate());
            bookIssueToUpdate.setReturnDate(updatedBookIssue.getReturnDate());
            return bookIssueRepo.save(bookIssueToUpdate);
        } else {
            return null;
        }
    }

    public void deleteBookIssue(int issueId) {
        bookIssueRepo.deleteById(issueId);
    }

}
