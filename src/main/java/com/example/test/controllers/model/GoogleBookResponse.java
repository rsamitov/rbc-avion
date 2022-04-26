package com.example.test.controllers.model;

import lombok.Data;

import java.util.List;

@Data
public class GoogleBookResponse {
    private List<GoogleBook> items;
}
