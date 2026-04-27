package com.example.spring_core_demo.repository.impl;

import com.example.spring_core_demo.model.Book;
import com.example.spring_core_demo.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class BookJdbcDaoImpl implements BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAllBooks() {
        return this.jdbcTemplate.query("SELECT * FROM books", this::mapRowToBook);
        
    }

    private Book mapRowToBook(ResultSet Book, int rowNum) throws SQLException {
        return new Book(
                Book.getLong("ID"),
                Book.getString("Title"),
                Book.getString("Author"),
                Book.getInt("Year")
        );
    }

    @Override
    public void saveBook(Book book) {
        this.jdbcTemplate.update("INSERT INTO books (title,author,year)" + " VALUES (?,?,?)", book.getTitle(), book.getAuthor(), book.getYear());
    }

    @Override
    public void deleteBookById(Long id) {
        this.jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }

    @Override
    public Optional<Book> getBookById(Long id)
    {
        List<Book> books = this.jdbcTemplate.query("SELECT * FROM books WHERE id = ?", this::mapRowToBook, id);
        if(books.size() > 0)
        {
            return Optional.of(books.get(0));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void updateBook(Book book) {
        this.jdbcTemplate.update("UPDATE books SET title = ?, author = ?, year = ? WHERE id = ?", book.getTitle(), book.getAuthor(), book.getYear(), book.getId());
    }
}
