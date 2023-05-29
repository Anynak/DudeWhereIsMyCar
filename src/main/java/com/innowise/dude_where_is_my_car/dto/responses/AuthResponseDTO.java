package com.innowise.dude_where_is_my_car.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {
    private String accessToken;

    private List<String> roles;

}