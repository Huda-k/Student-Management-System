package com.example.student.controller;


import com.example.student.entity.BookRecieve;
import com.example.student.repository.BookRecieveRepo;
import com.example.student.service.BookRecieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRecieveController {
    @Autowired
    private BookRecieveService service;

    @PostMapping("/saveBookRecieve")
    public BookRecieve saveBookRecieve(@RequestBody BookRecieve bookRecieve) {
        return service.saveBookRecieve(bookRecieve);
    }

    @GetMapping("/bookRecieveList")
    public List<BookRecieve> getAllBookRecieve() {
        return service.getAllBookRecieve();
    }

    @GetMapping("/getBookRecieveById/{recieveId}")
    public BookRecieve getBookRecieveById(@PathVariable("recieveId") int recieveId) {
        return service.getBookRecieveById(recieveId).orElse(null);
    }

    @PutMapping("/updateBookRecieve/{recieveId}")
    public BookRecieve updateBookRecieve(@PathVariable("recieveId") int recieveId, @RequestBody BookRecieve updateBookRecieve) {
        return service.updateBookRecieve(recieveId, updateBookRecieve);
    }

    @DeleteMapping("/deleteBookRecieve/{recieveId}")
    public String deleteBookRecieve(@PathVariable("recieveId") int recieveId) {
        service.deleteBookRecieve(recieveId);
        return "Deleted Successfully";
    }
}