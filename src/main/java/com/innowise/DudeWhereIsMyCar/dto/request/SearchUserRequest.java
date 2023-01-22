package com.innowise.DudeWhereIsMyCar.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class SearchUserRequest {
    //private Long userId;
    //private boolean isDeleted;
    //private String login;
    //private String name;
    //private String phone;
    //private String email;
    private String country;
    private String city;


}
