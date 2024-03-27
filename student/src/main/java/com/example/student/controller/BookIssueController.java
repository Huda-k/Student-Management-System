package com.example.student.controller;

import com.example.student.entity.BookIssue;
import com.example.student.repository.BookIssueRepo;
import com.example.student.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookIssueController {
    @Autowired
    private BookIssueService service;

    @PostMapping("/saveBookIssue")
    public BookIssue saveBookIssue(@RequestBody BookIssue bookIssue) {
        return service.saveBookIssue(bookIssue);
    }

    @GetMapping("/bookIssueList")
    public List<BookIssue> getAllBookIssue() {
        return service.getAllBookIssue();
    }

    @GetMapping("/getBookIssueById/{IssueId}")
    public BookIssue getBookIssueById(@PathVariable("IssueId") int IssueId) {
        return service.getBookIssueById(IssueId).orElse(null);
    }

    @PutMapping("/updateBookIssue/{IssueId}")
    public BookIssue updateBookIssue(@PathVariable("IssueId") int IssueId, @RequestBody BookIssue updateBookIssue) {
        return service.updateBookIssue(IssueId, updateBookIssue);
    }

    @DeleteMapping("/deleteBookIssue/{IssueId}")
    public String deleteBookIssue(@PathVariable("IssueId") int IssueId) {
        service.deleteBookIssue(IssueId);
        return "Deleted Successfully";
    }
}
