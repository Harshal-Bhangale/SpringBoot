package com.codewithharsh.REST_BasicFirst.controller;

import com.codewithharsh.REST_BasicFirst.model.Book;
import com.codewithharsh.REST_BasicFirst.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Book API!";
    }

    @GetMapping("/findbyid/{id}")
    public Book findBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/findall")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }
    
    @DeleteMapping("/delete")
    public String deleteAllBooks() {
        bookService.deleteAllBooks();
        return "All books have been deleted.";
    }
}
