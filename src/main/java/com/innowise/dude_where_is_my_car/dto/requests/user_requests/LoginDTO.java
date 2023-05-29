package com.innowise.dude_where_is_my_car.dto.requests.user_requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotNull
    @NotBlank
    private String login;

    @NotNull
    @NotBlank
    private String password;
}
