package com.innowise.DudeWhereIsMyCar.controllers.validators;

import com.innowise.DudeWhereIsMyCar.dto.requests.userRequests.RegisterUserRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterUserRequest> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegisterUserRequest userRequest, ConstraintValidatorContext context) {
        if (userRequest.getPassword() == null || userRequest.getPassword().isBlank()) {
            return false;
        }
        return userRequest.getPassword().equals(userRequest.getRepeatPassword());
    }
}
