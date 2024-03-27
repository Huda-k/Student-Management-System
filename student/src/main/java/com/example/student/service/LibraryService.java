package com.example.student.service;


import com.example.student.entity.Library;
import com.example.student.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepo libraryRepo;

    @Autowired
    public LibraryService(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }


    public List<Library> getAllLibrary() {
        return libraryRepo.findAll();
    }


    public Optional<Library> getLibraryById(int bookId) {
        return libraryRepo.findById(bookId);
    }

    public Library saveLibrary(Library library) {
        return libraryRepo.save(library);
    }

    public Library updateLibrary(int bookId, Library updatedLibrary) {
        Optional<Library> existingLibrary = libraryRepo.findById(bookId);
        if (existingLibrary.isPresent()) {
            Library libraryToUpdate = existingLibrary.get();
            libraryToUpdate.setTitle(updatedLibrary.getTitle());
            libraryToUpdate.setAuthor(updatedLibrary.getAuthor());
            libraryToUpdate.setPublisher(updatedLibrary.getPublisher());
            libraryToUpdate.setAvailability(updatedLibrary.getAvailability());
            return libraryRepo.save(libraryToUpdate);
        } else {
            return null;
        }
    }

    public void deleteLibrary(int bookId) {
        libraryRepo.deleteById(bookId);
    }

}