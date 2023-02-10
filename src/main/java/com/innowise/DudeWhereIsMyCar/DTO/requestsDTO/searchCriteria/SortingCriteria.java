package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class SortingCriteria {

    @NotNull(message = "sortBy can't be null")
    @NotBlank
    private String sortBy;

    @NotNull
    private Boolean ASC = true;

}
