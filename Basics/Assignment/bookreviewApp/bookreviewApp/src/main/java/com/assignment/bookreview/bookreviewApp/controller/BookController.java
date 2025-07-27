package com.assignment.bookreview.bookreviewApp.controller;

import com.assignment.bookreview.bookreviewApp.model.Book;
import com.assignment.bookreview.bookreviewApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        service.addBook(book);
        return ResponseEntity.ok("Book added successfully!");
    }
}
