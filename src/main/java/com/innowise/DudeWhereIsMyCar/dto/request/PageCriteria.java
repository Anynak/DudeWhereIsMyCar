package com.innowise.DudeWhereIsMyCar.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageCriteria {
    @Min(value = 1)
    private int pageNumber;

    @Min(value = 1)
    private int pageSize;

}
