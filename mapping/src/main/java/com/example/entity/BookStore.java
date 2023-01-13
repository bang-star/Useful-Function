package com.example.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @OneToMany(mappedBy = "bookStore")
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        this.books.add(book);

        System.out.println("bookStore : " + this.books);
        System.out.println("book : " + book);
    }

    public void addBook2(Book book){
        book.setBookStore(this);
        this.books.add(book);

        System.out.println("bookStore : " + this.books);
        System.out.println("book : " + book);
    }
}
