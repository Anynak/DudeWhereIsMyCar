package com.innowise.DudeWhereIsMyCar.validators;

import com.innowise.DudeWhereIsMyCar.dto.request.UserRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserRequest> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRequest userRequest, ConstraintValidatorContext context) {
        if (userRequest.getPassword() == null || userRequest.getPassword().isBlank()) {
            return false;
        }
        return userRequest.getPassword().equals(userRequest.getRepeatPassword());
    }
}
