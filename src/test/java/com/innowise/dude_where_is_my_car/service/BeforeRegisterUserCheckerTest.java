package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
import com.innowise.dude_where_is_my_car.exceptions.EmailAlreadyExistsException;
import com.innowise.dude_where_is_my_car.exceptions.PhoneNumberAlreadyExistsException;
import com.innowise.dude_where_is_my_car.exceptions.UserAlreadyExistsException;
import com.innowise.dude_where_is_my_car.repositories.UserRepository;
import com.innowise.dude_where_is_my_car.service.impl.BeforeRegisterUserChecker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class BeforeRegisterUserCheckerTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private BeforeRegisterUserChecker beforeRegisterUserChecker;

    @Test
    void userAlreadyExistsExceptionCheck() {
        Mockito.when(userRepository.existsByLogin(anyString())).thenReturn(true);
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setLogin("existingLogin");
        assertThrows(UserAlreadyExistsException.class, () -> {
            beforeRegisterUserChecker.check(registerUserRequest);
        });
    }

    @Test
    void emailAlreadyExistsExceptionCheck() {
        Mockito.when(userRepository.existsByEmail(anyString())).thenReturn(true);
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("existingEmail");
        assertThrows(EmailAlreadyExistsException.class, () -> {
            beforeRegisterUserChecker.check(registerUserRequest);
        });
    }

    @Test
    void phoneAlreadyExistsExceptionCheck() {
        Mockito.when(userRepository.existsByPhone(anyString())).thenReturn(true);
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setPhone("existingPhone");
        assertThrows(PhoneNumberAlreadyExistsException.class, () -> {
            beforeRegisterUserChecker.check(registerUserRequest);
        });
    }
}
