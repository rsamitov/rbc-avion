package com.example.test.service;

import com.example.test.adapter.BookAdapter;
import com.example.test.controllers.model.BookVO;
import com.example.test.controllers.model.GoogleBookResponse;
import com.example.test.entity.Book;
import com.example.test.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookAdapter bookAdapter;


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

//        "https://www.googleapis.com/books/v1/volumes?maxResults=5&orderBy=relevance&q=oliver%20sacks"
        GoogleBookResponse googleBooks = bookAdapter.getGoogleBooks("5", "relevance", "oliver sacks");
        return googleBooks.getItems().stream()
                .map(googleBook -> new BookVO(googleBook.getId(), googleBook.getVolumeInfo().getTitle()))
                .collect(Collectors.toList());
    }
}
