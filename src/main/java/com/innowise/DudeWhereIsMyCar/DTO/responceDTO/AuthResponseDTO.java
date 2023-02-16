package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken) {
      this.accessToken = accessToken;
    }
}