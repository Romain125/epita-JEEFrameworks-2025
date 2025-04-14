package org.example;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;
    @Embedded
    private Title title;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Author> author;
    @Enumerated(value = EnumType.STRING)
    private BookType type;
    @Transient
    private LocalDateTime dataFreshness = LocalDateTime.now();

    public LocalDateTime getDataFreshness() {
        return dataFreshness;
    }

    public void setDataFreshness(LocalDateTime dataFreshness) {
        this.dataFreshness = dataFreshness;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = new Title(title);
        this.author = Set.of(author);
    }

    public Book(String title, Author author, BookType type) {
        this.title = new Title(title);
        this.author = Set.of(author);
        this.type = type;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
