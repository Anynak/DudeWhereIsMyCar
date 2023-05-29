package com.innowise.dude_where_is_my_car.dto.requests.search_criteria;

import lombok.Data;

@Data
public class SearchUserRequest {
    private String country;
    private String city;
}
