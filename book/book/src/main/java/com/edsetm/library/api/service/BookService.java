package com.edsetm.library.api.service;

import com.edsetm.library.api.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book saveOrUpdate(Book book);
    boolean removeById(int id);
}
