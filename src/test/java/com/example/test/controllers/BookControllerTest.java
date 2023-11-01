package com.example.test.controllers;

import com.example.test.adapter.BookAdapter;
import com.example.test.controllers.model.GoogleBook;
import com.example.test.controllers.model.GoogleBookResponse;
import com.example.test.controllers.model.VolumeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookAdapter mockAdapter;

    @Test
    void testGetBooksFromGoogle() throws Exception {

        GoogleBookResponse res = new GoogleBookResponse();
        res.setItems(List.of(GoogleBook.builder()
                .id("someid")
                .volumeInfo(new VolumeInfo("some title"))
                .build()));
        when(mockAdapter.getGoogleBooks("5", "relevance", "oliver sacks"))
                .thenReturn(res);


        mockMvc.perform(get("/v1/books/google"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            [{
                            "id": "someid",
                            "name": "some title"
                            }]
                        """));
    }
}