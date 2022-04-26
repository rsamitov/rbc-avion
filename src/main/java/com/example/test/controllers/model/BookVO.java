package com.example.test.controllers.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookVO {
    private String id;
    @NotNull(message = "Name cannot be null")
    private String Name;
}
