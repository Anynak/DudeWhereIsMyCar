package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.DTO.mapers.UserMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.UserResponse;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.AuthResponseDTO;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.LoginDTO;
import com.innowise.DudeWhereIsMyCar.exceptions.AlreadyLoggedException;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.scurity.JWTGenerator;
import com.innowise.DudeWhereIsMyCar.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@CrossOrigin
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @PostMapping("/v1/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterUserRequest userRequest, Principal principal) {
        if (principal != null) throw new AlreadyLoggedException("user "+principal.getName()+" is already logged");

        User user = userService.registerUser(userRequest);
        UserResponse response = userMapper.toUserResponse(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/v1/login")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestBody @Valid LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

}
