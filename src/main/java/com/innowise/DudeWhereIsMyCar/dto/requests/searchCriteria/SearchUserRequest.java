package com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria;

import lombok.Data;

@Data
public class SearchUserRequest {
    private String country;
    private String city;
}
