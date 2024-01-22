package com.edsetm.library.api.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

/**
 * Model for storing book details
 */
@Entity(name = "book")
public class Book {

    @Id
    int id;

    @Column(name = "book_name")
    @NotNull
    String bookName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "author",referencedColumnName = "id",nullable = false)
    Author author;

    @Column(name = "year_of_publishing")
    String year;

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
