package com.innowise.DudeWhereIsMyCar.user;
import lombok.Data;

@Data
public class SearchUserRequest {
    private String country="";
    private String city="";
}
