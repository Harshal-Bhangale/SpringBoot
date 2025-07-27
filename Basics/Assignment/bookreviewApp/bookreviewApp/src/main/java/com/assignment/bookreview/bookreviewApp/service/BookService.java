package com.assignment.bookreview.bookreviewApp.service;

import com.assignment.bookreview.bookreviewApp.model.Book;
import com.assignment.bookreview.bookreviewApp.model.Review;
import com.assignment.bookreview.bookreviewApp.repository.BookRepository;
import com.assignment.bookreview.bookreviewApp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository  repository;

    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }

    public Book getBookById(Integer id) {
        return repository.findBookById(id);
    }

}
