package org.bibliobarrio.book.application;

import org.bibliobarrio.book.domain.Book;
import org.bibliobarrio.book.domain.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book newBook) {
        bookService.addBook(newBook);
        return ResponseEntity.status(HttpStatus.valueOf(201)).build();
    }
}