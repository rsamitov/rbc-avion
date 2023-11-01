package com.example.test.controllers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@Jacksonized
public class GoogleBook {

    private String id;
    private VolumeInfo volumeInfo;
}
