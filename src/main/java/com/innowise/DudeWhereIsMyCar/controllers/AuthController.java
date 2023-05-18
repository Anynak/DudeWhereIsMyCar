package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.configs.scurity.JWTGenerator;
import com.innowise.DudeWhereIsMyCar.dto.mapers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.userRequests.LoginDTO;
import com.innowise.DudeWhereIsMyCar.dto.requests.userRequests.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.AuthResponseDTO;
import com.innowise.DudeWhereIsMyCar.dto.responses.UserResponse;
import com.innowise.DudeWhereIsMyCar.exceptions.AlreadyLoggedException;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.service.AuthenticationService;
import com.innowise.DudeWhereIsMyCar.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationService authenticate;
    private final JWTGenerator jwtGenerator;


    @PostMapping("/v1/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterUserRequest userRequest, Principal principal) {
        if (principal != null) throw new AlreadyLoggedException("user " + principal.getName() + " is already logged");
        User user = userService.registerUser(userRequest);
        log.info("new user was created. userId = {}, login = {}", user.getUserId(), user.getLogin());
        UserResponse response = userMapper.toUserResponse(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/v1/login")
    public ResponseEntity<AuthResponseDTO> authUser(@RequestBody @Valid LoginDTO loginDTO) {
        MDC.put("User.login", loginDTO.getLogin());
        log.info("attempt to login user");
        Authentication authentication = authenticate.authenticate(loginDTO.getLogin(), loginDTO.getPassword());
        String token = jwtGenerator.generateToken(authentication);
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(token, roles);
        MDC.clear();
        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }

}
