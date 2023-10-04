package edu.miu.waa.lab3.service;

import edu.miu.waa.lab3.model.Book;
import edu.miu.waa.lab3.model.BookV2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    public List<Book> getBooks(){
        return Arrays.asList(
                new Book(1, "Headfirst Servlet & JSP"),
                new Book(2, "Spring Boot in Action"),
                new Book(3, "React for dummies")
        );
    }

    public List<BookV2> getBooksV2(){
        return Arrays.asList(
                new BookV2(1, "Headfirst Servlet & JSP", "O'Reilly"),
                new BookV2(2, "Spring Boot in Action", "Andrew Glover"),
                new BookV2(3, "React for dummies", "community")
        );
    }
}
