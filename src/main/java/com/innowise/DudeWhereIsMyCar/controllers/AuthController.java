package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.request.LoginDTO;
import com.innowise.DudeWhereIsMyCar.dto.request.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.AuthResponseDTO;
import com.innowise.DudeWhereIsMyCar.dto.response.UserResponse;
import com.innowise.DudeWhereIsMyCar.entity.User;
import com.innowise.DudeWhereIsMyCar.exceptions.AlreadyLoggedException;
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
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterUserRequest userRequest, Principal principal) {
        if (principal != null) throw new AlreadyLoggedException();

        User user = userService.registerUser(userRequest);
        UserResponse response = userMapper.toUserResponse(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
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
