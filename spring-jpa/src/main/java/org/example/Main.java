package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        AuthorRepository authorRepository = context.getBean("authorRepository", AuthorRepository.class);
        Author tolkien = new Author("J.R.R. Tolkien");
        Author twi = new Author("AutriceTwilight");
        authorRepository.save(tolkien);
        authorRepository.save(twi);
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        bookRepository.save(new Book("Le Seigneur des Anneaux - La communauté de l'anneau", tolkien, BookType.Aventure));
        bookRepository.save(new Book("Le Seigneur des Anneaux - Les deux tours", tolkien, BookType.Aventure));
        bookRepository.save(new Book("Le Seigneur des Anneaux - Le Retour du Roi", tolkien, BookType.Aventure));
        bookRepository.save(new Book("Twilight", twi, BookType.Love));
        List<Book> allBooks = bookRepository.findByType(BookType.Aventure);
        System.out.println(allBooks.stream().map(Book::toString).collect(Collectors.joining("\n")));

        TransactionalBookService service = context.getBean(TransactionalBookService.class);
        service.transactionalMethod();
    }
}