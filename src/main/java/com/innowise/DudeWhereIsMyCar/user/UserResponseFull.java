package com.innowise.DudeWhereIsMyCar.user;

import lombok.Data;

@Data
public class UserResponseFull {
    private String login;
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;
    private Boolean isDeleted;
}
