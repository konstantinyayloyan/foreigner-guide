package com.upwork.foreigner.guide.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class PlaceDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String type;

    @Positive
    private Long latitude;

    @Positive
    private Long longitude;
}
