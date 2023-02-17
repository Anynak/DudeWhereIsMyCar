package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
    private String login;
    private String password;
}
