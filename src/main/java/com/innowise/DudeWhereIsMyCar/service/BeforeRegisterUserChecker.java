package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.exceptions.EmailAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.exceptions.PhoneNumberAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.exceptions.UserAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
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
