package edu.miu.waa.lab1.controller;

import edu.miu.waa.lab1.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(("/api/v1"))
public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks() {
        Book b1 = Book.builder().id(1).title("Java").isbn("1617297577").build();
        Book b2 = Book.builder().id(2).title("Spring in Action, Sixth Edition").isbn("978-1617297571").build();
        Book b3 = Book.builder().id(3).title("Learning React, 2nd Edition").isbn("9781492051725").build();

        return Arrays.asList(b1, b2, b3);
    }
}
