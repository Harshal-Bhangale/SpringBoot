package com.assignment.bookreview.bookreviewApp.repository;

/*
Use in-memory storage:
BookRepository: store books in a list, with methods to add, get all, get by ID, and delete by ID.
*/

import com.assignment.bookreview.bookreviewApp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks()
    {
        return books;
    }
    public void addBook(Book book)
    {
        books.add(book);
    }
    public Book findBookById(Integer id)
    {
        return books.stream().filter(b-> b.getId().equals(id)).findFirst().orElse(null);
    }
}
