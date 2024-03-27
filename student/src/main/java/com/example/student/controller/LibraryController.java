package com.example.student.controller;


import com.example.student.entity.Library;
import com.example.student.repository.LibraryRepo;
import com.example.student.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService service;

    @PostMapping("/saveLibrary")
    public Library saveLibrary(@RequestBody Library library) {
        return service.saveLibrary(library);
    }

    @GetMapping("/libraryList")
    public List<Library> getAllLibrary() {
        return service.getAllLibrary();
    }

    @GetMapping("/getLibraryById/{bookId}")
    public Library getLibraryById(@PathVariable("bookId") int bookId) {
        return service.getLibraryById(bookId).orElse(null);
    }

    @PutMapping("/updateLibrary/{bookId}")
    public Library updateLibrary(@PathVariable("bookId") int bookId, @RequestBody Library updateLibrary) {
        return service.updateLibrary(bookId, updateLibrary);
    }

    @DeleteMapping("/deleteLibrary/{bookId}")
    public String deleteLibrary(@PathVariable("bookId") int bookId) {
        service.deleteLibrary(bookId);
        return "Deleted Successfully";
    }
}