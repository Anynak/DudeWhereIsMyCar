package com.innowise.DudeWhereIsMyCar.dto.request;
import lombok.Data;

@Data
public class SearchUserRequest {
    private String country;
    private String city;
}
