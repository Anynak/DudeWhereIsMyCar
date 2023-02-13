package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria;

import lombok.Data;


@Data
public class SortingCriteria {

    private String sortBy;

    private Boolean ASC = true;

}
