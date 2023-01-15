package com.example.mapping;


import com.example.entity.Book;
import com.example.entity.BookStore;
import com.example.repo.BookRepository;
import com.example.repo.BookStoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@SpringBootTest
class MappingApplicationTests {

    @Autowired
    BookStoreRepository bookStoreRepository;
    @Autowired
    BookRepository bookRepository;

    @DisplayName("[1:N] Book과 BookStore은 1:N 관계 - 연관관계 설정이 되지 않는다.")
    @Test
    void BookAndBookStore_TEST1() {
        BookStore bookStore = new BookStore();
        bookStore.setName("수근 문고");
        bookStoreRepository.save(bookStore);

        Book book = new Book();
        book.setTitle("누가 내 머리에 똥쌋어?");

        bookStore.addBook(book);
        bookRepository.save(book);
    }

    @DisplayName("[1:N] Book과 BookStore은 1:N 관계 - 연관관계 설정 정상 완료")
    @Test
    void BookAndBookStore_TEST2() {
        BookStore bookStore = new BookStore();
        bookStore.setName("호동 문고");
        bookStoreRepository.save(bookStore);

        Book book = new Book();
        book.setTitle("아낌없이 주는 나무");

        bookStore.addBook2(book);
        bookRepository.save(book);
    }

}
