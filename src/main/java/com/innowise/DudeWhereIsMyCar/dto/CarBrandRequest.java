package com.innowise.DudeWhereIsMyCar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarBrandRequest {

    private Long brandId;

    @NotBlank
    @NotNull
    private String brandName;
}
