package com.example.test.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name="id", nullable = false, unique = true)
    private String id;

    @Column(name="name", nullable = false)
    private String name;
}
