package com.example.spring_core_demo.service.impl;

import com.example.spring_core_demo.bean.common.Mapper;
import com.example.spring_core_demo.dto.BookDto;
import com.example.spring_core_demo.model.Book;
import com.example.spring_core_demo.repository.BookDao;
import com.example.spring_core_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    Mapper mapper;

    @Override
    public List<BookDto> getAllBooks(){
        List<Book> book = this.bookDao.getAllBooks();
        return mapper.mapList(book, BookDto.class);
    }

    @Override
    public void saveBook(BookDto bookDto){
        Book book = this.mapper.map(bookDto, Book.class);
        this.bookDao.saveBook(book);

    }

    @Override
    public void deleteBookById(Long id)
    {
        this.bookDao.deleteBookById(id);
    }

    @Override
    public Optional<BookDto> getBookById(Long id)
    {
        Optional<Book> result = this.bookDao.getBookById(id);
        if(result.isPresent())
        {
            BookDto dto = this.mapper.map(result.get(), BookDto.class);
            return Optional.of(dto);
        }
        else
        {
            return Optional.empty();
        }
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Book book = this.mapper.map(bookDto, Book.class);
        this.bookDao.updateBook(book);

    }

}
