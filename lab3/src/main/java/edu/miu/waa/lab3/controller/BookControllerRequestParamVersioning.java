package edu.miu.waa.lab3.controller;

import edu.miu.waa.lab3.model.Book;
import edu.miu.waa.lab3.model.BookV2;
import edu.miu.waa.lab3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookControllerRequestParamVersioning {
    BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books", params = "version=1")
    public List<Book> getBooks(@RequestParam String version) {
        return bookService.getBooks();

    }

    @GetMapping(value = "/books", params = "version=2")
    public List<BookV2> getBooksV2(@RequestParam String version) {
        return bookService.getBooksV2();
    }

}
