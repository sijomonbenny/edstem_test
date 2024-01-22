package com.edsetm.library.api.service.impl;

import com.edsetm.library.api.entity.Book;
import com.edsetm.library.api.repository.BookRepository;
import com.edsetm.library.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    /*
    Method for fetching all book data
     */
    @Override
    public List<Book> getAllBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            System.out.println("Exception Occured while fetching");
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    /**
     * Method for getting a book using Id
     */
    public Book getBookById(int id) {
        try {
            return bookRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Exception Occured While getting book data");
            return null;
        }
    }

    @Override
    /**
     * Method common for saving and updating a book data
     */
    public Book saveOrUpdate(Book book) {
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            System.out.println("Exception occured while saving book data");
            return null;
        }
    }

    @Override
    /**
     * Method for removing a book using id
     */
    public boolean removeById(int id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
