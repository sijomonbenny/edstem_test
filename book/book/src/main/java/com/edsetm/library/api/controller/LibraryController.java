package com.edsetm.library.api.controller;

import com.edsetm.library.api.entity.Book;
import com.edsetm.library.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API to Manage All the Library Operations.
 * Author: Sijo Benny
 */
@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    BookService bookService;
    /*
    API End Point to fetch all Books in the library with author info
     */
    @GetMapping("book/list")
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if(books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Books are Found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }
    }

    /*
    API End Point to get book details using ID
     */
    @GetMapping("book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if(book != null) {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Books are Found with ID");
        }
    }

    /*
    API End Point to fetch onboard a new book
     */
    @PostMapping("book/onboard")
    public ResponseEntity<?> onboardBook(@RequestBody @Validated Book book) {
        Book onboaredBook = bookService.saveOrUpdate(book);
        if(onboaredBook != null) {
            return ResponseEntity.status(HttpStatus.OK).body(onboaredBook);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to Save the Book");
        }

    }


    /*
    API End Point to update a book details
     */
    @PutMapping("book/update")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.saveOrUpdate(book);
        if(updatedBook != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to Modify the Book Data");
        }
    }

    /*
    API End Point to remove a book using id
     */
    @DeleteMapping("book/remove/{id}")
    public ResponseEntity<?> removeBookById(@PathVariable int id) {
        if(bookService.removeById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Book Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to Remove the Book");
        }
    }

}
