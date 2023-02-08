package com.innowise.DudeWhereIsMyCar.searchCriteria;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class SortingCriteria {

    @NotNull
    @NotBlank
    private String sortBy;

    @NotNull
    private Boolean ASC = true;

}
