package edu.miu.waa.lab3.controller;

import edu.miu.waa.lab3.service.BookService;
import edu.miu.waa.lab3.model.Book;
import edu.miu.waa.lab3.model.BookV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookControllerCustomHeaderVersioning {

    BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books", headers = "X-Version=1")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = "/books", headers = "X-Version=2")
    public List<BookV2> getBooksV2() {
        return bookService.getBooksV2();
    }
}
