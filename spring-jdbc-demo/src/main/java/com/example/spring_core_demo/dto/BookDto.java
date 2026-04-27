package com.example.spring_core_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookDto {

    Long id;
    // @NotNull
    // @Size(min = 5, message = "Author must be at least 5 characters long")
    String author;

    // @NotNull
    // @Size(min = 5, message = "Title must be at least 5 character long")
    String title;

    // @NotNull
    int year;

    public BookDto(Long id, String author, String title, int year){
        super();
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
    }
}
