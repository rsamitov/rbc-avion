package com.example.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> demo(@RequestHeader String requestId){
        return new ResponseEntity<>("Hello Demo!", HttpStatus.OK);

    }
}
