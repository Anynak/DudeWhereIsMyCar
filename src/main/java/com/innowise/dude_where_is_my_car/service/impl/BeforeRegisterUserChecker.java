package com.innowise.dude_where_is_my_car.service.impl;


import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
import com.innowise.dude_where_is_my_car.exceptions.EmailAlreadyExistsException;
import com.innowise.dude_where_is_my_car.exceptions.PhoneNumberAlreadyExistsException;
import com.innowise.dude_where_is_my_car.exceptions.UserAlreadyExistsException;
import com.innowise.dude_where_is_my_car.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeforeRegisterUserChecker {
    private final UserRepository userRepository;

    public void check(RegisterUserRequest userReq) {
        boolean loginExists = userRepository.existsByLogin(userReq.getLogin());
        if (loginExists) throw new UserAlreadyExistsException("login " + userReq.getLogin() + " already exists");

        boolean emailExists = userRepository.existsByEmail(userReq.getEmail());
        if (emailExists) throw new EmailAlreadyExistsException("email " + userReq.getEmail() + " already exists");

        boolean phoneExists = userRepository.existsByPhone(userReq.getPhone());
        if (phoneExists)
            throw new PhoneNumberAlreadyExistsException("phone number " + userReq.getPhone() + " already exists");
    }
}
