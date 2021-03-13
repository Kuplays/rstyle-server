package com.kuplays.rstyle.repositories;

import com.kuplays.rstyle.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT book FROM BookEntity book WHERE book.id = ?1")
    BookEntity findByGivenId(Long id);
}
