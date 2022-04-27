package com.example.test.adapter;

import com.example.test.controllers.model.GoogleBookResponse;
import org.springframework.web.bind.annotation.RequestParam;

//TODO 3

public interface BookAdapter {

    GoogleBookResponse getGoogleBooks(@RequestParam String maxResults, @RequestParam String orderBy, @RequestParam String q );
}
