package com.edsetm.library.api.service;

import com.edsetm.library.api.entity.Author;
import com.edsetm.library.api.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {

    @Mock
    BookService bookService;

    @Test
    public void testFetchAllBookWithEmptyDatabase() {
        Assert.assertEquals(true, bookService.getAllBooks().isEmpty());
    }

    @Test
    public void testSavingOfBooks() {
        Book book = getBook();
        when(bookService.saveOrUpdate(book)).thenReturn(book);
        Assert.assertEquals(0, bookService.getAllBooks().size());
    }

    public Book getBook() {
        Book book = new Book();
        book.setBookName("Test Book");
        book.setYear("2024");
        Author author = new Author();
        author.setAuthorName("Test AUthor");
        book.setAuthor(author);
        return book;
    }
}
