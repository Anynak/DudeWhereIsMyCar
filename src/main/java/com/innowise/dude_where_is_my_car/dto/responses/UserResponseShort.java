package com.innowise.dude_where_is_my_car.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseShort {
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;
}
