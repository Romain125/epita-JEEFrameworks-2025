package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByType(BookType type);
    List<Book> findTop3ByTypeOrderByIsbnDesc(BookType type);
    Book findFirstByTitle_OriginalTitleContaining(String partOfTitle);


}
