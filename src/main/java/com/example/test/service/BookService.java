package com.example.test.service;

import com.example.test.controllers.model.BookVO;
import com.example.test.entity.Book;
import com.example.test.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookVO saveBook(BookVO bookVO){
        Book book = new Book();
        book.setId(bookVO.getId());
        book.setName(bookVO.getName());

        bookRepository.save(book);

        bookVO.setId(book.getId());

        return bookVO;
    }

    //TODO 3 use feign client bookAdapter to retrieve books
    public List<BookVO> retrieveBookFromGoogle() {
        return new ArrayList<>();
    }
}
