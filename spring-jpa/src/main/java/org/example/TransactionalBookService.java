package org.example;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionalBookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    //@Autowired
    public TransactionalBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void transactionalMethod(){
        Author romain = new Author("Romain");
        authorRepository.save(romain);
        Book b = new Book("MyAwesomeBook", romain);
        bookRepository.save(b);
        System.out.println("Book Saved !");
        //Ou pas !
        throw new RuntimeException();
    }

}
