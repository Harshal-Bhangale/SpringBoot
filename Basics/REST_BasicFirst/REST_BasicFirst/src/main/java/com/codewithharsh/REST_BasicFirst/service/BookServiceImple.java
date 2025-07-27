package com.codewithharsh.REST_BasicFirst.service;

import com.codewithharsh.REST_BasicFirst.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImple  implements BookService {
    private final List<Book> bookList = new ArrayList<>();

    // Constructor: add some dummy books
    public BookServiceImple() {
        bookList.add(new Book(1, "Clean Code", "Robert C. Martin"));
        bookList.add(new Book(2, "Effective Java", "Joshua Bloch"));
        bookList.add(new Book(3, "Spring in Action", "Craig Walls"));
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(bookList); // return a copy for safety
    }

    @Override
    public Book findBookById(int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteAllBooks() {
        bookList.clear();
    }

}
