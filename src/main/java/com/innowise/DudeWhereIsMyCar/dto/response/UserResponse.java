package com.innowise.DudeWhereIsMyCar.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private String login;
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;

}
