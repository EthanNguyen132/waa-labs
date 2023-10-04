package edu.miu.waa.lab3.controller;

import edu.miu.waa.lab3.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    List<Book> bookList = new ArrayList<>();

    public BookController() {
        bookList.add(new Book(1, "Headfirst Servlet & JSP"));
        bookList.add(new Book(2, "Spring Boot in Action"));
        bookList.add(new Book(3, "React for dummies"));
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookList;
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) throws Exception {
        return bookList
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("Not found"));
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveBook(@RequestBody Book book) {
        bookList.add(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable int id, @RequestBody Book book) throws Exception {
        Optional<Book> old = bookList
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        if (old.isPresent()) {
            var oldBook = old.get();
            oldBook.setTitle(book.getTitle());
            return;
        }
        throw new Exception("Not Found");
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        bookList = bookList.stream().filter(b -> b.getId() != id)
                .collect(Collectors.toList());
    }
}
