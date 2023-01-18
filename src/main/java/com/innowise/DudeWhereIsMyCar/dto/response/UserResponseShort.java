package com.innowise.DudeWhereIsMyCar.dto.response;

import lombok.Data;

@Data
public class UserResponseShort {
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;
}
