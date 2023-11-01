package com.example.test.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class BookVO {
    private String id;
    @NotNull(message = "Name cannot be null")
    private String name;
}
