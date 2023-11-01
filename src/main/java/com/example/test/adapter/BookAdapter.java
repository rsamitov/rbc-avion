package com.example.test.adapter;

import com.example.test.controllers.model.GoogleBookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//TODO 3

@FeignClient(value = "googleBooks", url = "https://www.googleapis.com/")
public interface BookAdapter {

    @RequestMapping(method = RequestMethod.GET, value = "/books/v1/volumes")
    GoogleBookResponse getGoogleBooks(@RequestParam String maxResults,
                                      @RequestParam String orderBy,
                                      @RequestParam String q );
}
