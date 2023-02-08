package com.innowise.DudeWhereIsMyCar.user;

import com.innowise.DudeWhereIsMyCar.validators.PasswordMatch;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@PasswordMatch
public class RegisterUserRequest {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$")
    private String login;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$")
    private String name;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$")
    private String phone;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$")
    private String password;

    private String repeatPassword;


}
