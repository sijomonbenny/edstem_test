package com.edsetm.library.api.repository;

import com.edsetm.library.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book WHERE year_of_publishing between ?1 and ?2;", nativeQuery = true)
    List<Book> getBookByYearRange(String start, String end);
}
