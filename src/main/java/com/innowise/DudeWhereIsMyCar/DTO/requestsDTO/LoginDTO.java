package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LoginDTO {
    private String login;
    private String password;
}
