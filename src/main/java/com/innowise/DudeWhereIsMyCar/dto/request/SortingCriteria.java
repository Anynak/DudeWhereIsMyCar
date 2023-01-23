package com.innowise.DudeWhereIsMyCar.dto.request;
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
