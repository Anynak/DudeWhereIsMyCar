package com.innowise.dude_where_is_my_car.dto.requests.search_criteria;

import lombok.Data;


@Data
public class SortingCriteria {

    private String sortBy;

    private Boolean asc = true;

}
