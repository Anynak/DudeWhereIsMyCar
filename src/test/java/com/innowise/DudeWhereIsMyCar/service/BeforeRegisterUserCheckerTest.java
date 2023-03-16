package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.requests.userRequests.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.exceptions.EmailAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.exceptions.PhoneNumberAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.exceptions.UserAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
import com.innowise.DudeWhereIsMyCar.service.impl.BeforeRegisterUserChecker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class BeforeRegisterUserCheckerTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private BeforeRegisterUserChecker beforeRegisterUserChecker;

    @Test
    public void userAlreadyExistsExceptionCheck() {
        Mockito.when(userRepository.existsByLogin(anyString())).thenReturn(true);
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setLogin("existingLogin");
        assertThrows(UserAlreadyExistsException.class, () -> {
            beforeRegisterUserChecker.check(registerUserRequest);
        });
    }

    @Test
    public void emailAlreadyExistsExceptionCheck() {
        Mockito.when(userRepository.existsByEmail(anyString())).thenReturn(true);
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("existingEmail");
        assertThrows(EmailAlreadyExistsException.class, () -> {
            beforeRegisterUserChecker.check(registerUserRequest);
        });
    }

    @Test
    public void phoneAlreadyExistsExceptionCheck() {
        Mockito.when(userRepository.existsByPhone(anyString())).thenReturn(true);
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setPhone("existingPhone");
        assertThrows(PhoneNumberAlreadyExistsException.class, () -> {
            beforeRegisterUserChecker.check(registerUserRequest);
        });
    }
}
