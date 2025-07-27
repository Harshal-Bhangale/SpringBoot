package com.codewithharsh.REST_BasicFirst.service;

import com.codewithharsh.REST_BasicFirst.model.Book;
import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(int id);
    void deleteAllBooks();
}
