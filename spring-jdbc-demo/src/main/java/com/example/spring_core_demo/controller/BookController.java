package com.example.spring_core_demo.controller;

import com.example.spring_core_demo.bean.common.BookValidator;
import com.example.spring_core_demo.dto.BookDto;
import com.example.spring_core_demo.model.Book;
import com.example.spring_core_demo.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookValidator bookValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(bookValidator);
    }

    @GetMapping
    String getAllBooks(Model model) {
        log.info("Getting all books");
        List<BookDto> books = this.bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("/new")
    String newBook(Model model) {
        log.info("Getting new book");
        BookDto book = new BookDto();
        book.setTitle("Default");
        model.addAttribute("book", book);
        return "books/new";
    }

    @PostMapping("/new")
    String saveBook(Model model,@ModelAttribute("book") @Validated BookDto book, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "books/new";
        } else {
            log.info("Saving Book" + book);
            this.bookService.saveBook(book);

            return "redirect:/books";

        }
    }

    @GetMapping("/delete/{id}")
    String deleteBook(@PathVariable Long id, Model model) {
        log.info("Deleting Book with id: " + id);
        this.bookService.deleteBookById(id);
        model.addAttribute("message", "Book id " + id + " deleted successfully");
        List<BookDto> books = this.bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("/edit/{id}")
    String editBook(@PathVariable Long id, Model model) {
        log.info("Editing Book with id: " + id);
        Optional<BookDto> book = this.bookService.getBookById(id);
        model.addAttribute("book", book.get());
        return "books/new";
    }

    @PostMapping("/edit/{id}")
    String updateBook(@PathVariable Long id, Model model,@ModelAttribute("book") @Validated BookDto book, BindingResult result) {
        log.info("Updating Book with id: " + id);
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "books/new";
        } else {
            log.info("Editing Book with id: " + id);
            this.bookService.updateBook(book);
            model.addAttribute("message", "Book id " + id + " successfully updated");
            List<BookDto> books = this.bookService.getAllBooks();
            model.addAttribute("books", books);
            return "books/index";
        }
    }
}



