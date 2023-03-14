package com.innowise.DudeWhereIsMyCar.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer ";
    private List<String> roles;

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}