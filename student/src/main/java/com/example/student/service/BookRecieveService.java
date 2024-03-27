package com.example.student.service;


import com.example.student.entity.BookRecieve;
import com.example.student.entity.Library;
import com.example.student.repository.BookRecieveRepo;
import com.example.student.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookRecieveService {
    private final BookRecieveRepo bookRecieveRepo;

    @Autowired
    public BookRecieveService(BookRecieveRepo bookRecieveRepo) {
        this.bookRecieveRepo = bookRecieveRepo;
    }


    public List<BookRecieve> getAllBookRecieve() {
        return bookRecieveRepo.findAll();
    }


    public Optional<BookRecieve> getBookRecieveById(int recieveId) {
        return bookRecieveRepo.findById(recieveId);
    }

    public BookRecieve saveBookRecieve(BookRecieve bookRecieve) {
        return bookRecieveRepo.save(bookRecieve);
    }

    public BookRecieve updateBookRecieve(int recieveId, BookRecieve updatedBookRecieve) {
        Optional<BookRecieve> existingBookRecieve = bookRecieveRepo.findById(recieveId);
        if (existingBookRecieve.isPresent()) {
            BookRecieve bookRecieveToUpdate = existingBookRecieve.get();
            bookRecieveToUpdate.setRecieveDate(updatedBookRecieve.getRecieveDate());
            return bookRecieveRepo.save(bookRecieveToUpdate);
        } else {
            return null;
        }
    }

    public void deleteBookRecieve(int recieveId) {
        bookRecieveRepo.deleteById(recieveId);
    }

}