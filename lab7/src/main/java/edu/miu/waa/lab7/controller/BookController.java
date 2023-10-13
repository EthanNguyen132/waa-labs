package edu.miu.waa.lab7.controller;

import edu.miu.waa.lab7.exception.RecordNotFoundException;
import edu.miu.waa.lab7.model.Book;
import edu.miu.waa.lab7.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long bookId) {
        Book b = bookRepository.findById(bookId).orElseThrow(() -> new RecordNotFoundException("No such book!"));
        if (!bookId.equals(b.getId())) {
            throw new RecordNotFoundException("No such book!");
        }
        return bookRepository.save(book);
    }

    @DeleteMapping("{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
