package com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria;

import lombok.Data;


@Data
public class SortingCriteria {

    private String sortBy;

    private Boolean ASC = true;

}
