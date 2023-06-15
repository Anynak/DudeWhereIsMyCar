package com.innowise.dude_where_is_my_car.service;


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
        String alreadyExistsLogLabel = " already exists";

        boolean loginExists = userRepository.existsByLogin(userReq.getLogin());
        if (loginExists) throw new UserAlreadyExistsException("login " + userReq.getLogin() + alreadyExistsLogLabel);

        boolean emailExists = userRepository.existsByEmail(userReq.getEmail());
        if (emailExists) throw new EmailAlreadyExistsException("email " + userReq.getEmail() + alreadyExistsLogLabel);

        boolean phoneExists = userRepository.existsByPhone(userReq.getPhone());
        if (phoneExists)
            throw new PhoneNumberAlreadyExistsException("phone number " + userReq.getPhone() + alreadyExistsLogLabel);
    }
}
