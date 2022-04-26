package com.example.test.controllers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GoogleBook {

    private String id;
    private VolumeInfo volumeInfo;
}
