package com.example.spring_core_demo.repository;

import com.example.spring_core_demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    List<Book> getAllBooks();
    void saveBook(Book book);
    void deleteBookById(Long id);
    Optional<Book> getBookById(Long id);
    void updateBook(Book book);
}
