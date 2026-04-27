package com.example.spring_core_demo.service;

import com.example.spring_core_demo.dto.BookDto;
import com.example.spring_core_demo.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDto> getAllBooks();
    void saveBook(BookDto book);
    void deleteBookById(Long id);
    Optional<BookDto> getBookById(Long id);
    void updateBook(BookDto book);
}
