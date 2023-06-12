package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.configs.scurity.JWTGenerator;
import com.innowise.dude_where_is_my_car.dto.mapers.UserMapper;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.LoginDTO;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
import com.innowise.dude_where_is_my_car.dto.responses.AuthResponseDTO;
import com.innowise.dude_where_is_my_car.dto.responses.UserResponse;
import com.innowise.dude_where_is_my_car.exceptions.AlreadyLoggedException;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.service.AuthenticationService;
import com.innowise.dude_where_is_my_car.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/auth/v1")
@Slf4j
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationService authenticationService;
    private final JWTGenerator jwtGenerator;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterUserRequest userRequest, Principal principal) {
        if (principal != null) throw new AlreadyLoggedException("user " + principal.getName() + " is already logged");
        User user = userService.registerUser(userRequest);
        log.info("new user was created. userId = {}, login = {}", user.getUserId(), user.getLogin());
        UserResponse response = userMapper.toUserResponse(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authUser(@RequestBody @Valid LoginDTO loginDTO, HttpSession session) {
        log.info("attempt to login user");
        Authentication authentication = authenticationService.authenticate(loginDTO.getLogin(), loginDTO.getPassword());
        String token = jwtGenerator.generateToken(authentication, session.getId());
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(token, roles);
        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }

}
