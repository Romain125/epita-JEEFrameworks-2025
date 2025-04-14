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
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        bookRepository.save(new Book("Le Seigneur des Anneaux - La communauté de l'anneau", "J.R.R. Tolkien", BookType.Aventure));
        bookRepository.save(new Book("Le Seigneur des Anneaux - Les deux tours", "J.R.R. Tolkien", BookType.Aventure));
        bookRepository.save(new Book("Le Seigneur des Anneaux - Le Retour du Roi", "J.R.R. Tolkien", BookType.Aventure));
        bookRepository.save(new Book("Twilight", "AZERTYUIO", BookType.Love));
        List<Book> allBooks = bookRepository.findByType(BookType.Aventure);
        System.out.println(allBooks.stream().map(Book::toString).collect(Collectors.joining("\n")));
    }
}