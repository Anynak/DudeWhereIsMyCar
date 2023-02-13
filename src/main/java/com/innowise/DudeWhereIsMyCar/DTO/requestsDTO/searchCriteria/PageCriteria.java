package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageCriteria {
    @Min(value = 1)
    private int pageNumber = 1;

    @Min(value = 1)
    @Max(value = 100)
    private int pageSize = 10;

}
