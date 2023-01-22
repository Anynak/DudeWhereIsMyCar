package com.innowise.DudeWhereIsMyCar.dto.request;

import lombok.Data;

@Data
public class SortingCriteria {
    private String sortBy;
    private Boolean ASC = true;

}
