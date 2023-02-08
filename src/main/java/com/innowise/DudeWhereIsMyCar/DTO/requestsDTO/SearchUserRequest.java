package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO;
import lombok.Data;

@Data
public class SearchUserRequest {
    private String country="";
    private String city="";
}
