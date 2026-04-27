package com.example.spring_core_demo.bean.common;

import com.example.spring_core_demo.dto.BookDto;
import com.example.spring_core_demo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.lang.annotation.Target;

@Component
@Slf4j
public class BookValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors){

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "author.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty");

        BookDto book = (BookDto) obj;
        if (book.getTitle()!= null && book.getTitle().length() > 1)
        {
            String title = book.getTitle();
            String upperCase = (title.charAt(0) + "").toUpperCase();
            String startLetter = title.charAt(0) + "";
            if (!startLetter.equals(upperCase))
            {
                errors.rejectValue("title", "title.start.upper");
            }
        }


    }
}
