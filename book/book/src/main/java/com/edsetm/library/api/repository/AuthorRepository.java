package com.edsetm.library.api.repository;

import com.edsetm.library.api.entity.Author;
import com.edsetm.library.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT author FROM book GROUP BY author HAVING  COUNT(*)  > 1;", nativeQuery = true)
    List<Author> authorsWithMoreThanOneBook();
}
