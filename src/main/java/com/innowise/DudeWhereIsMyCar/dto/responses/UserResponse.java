package com.innowise.DudeWhereIsMyCar.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {
    private String login;
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;

}
