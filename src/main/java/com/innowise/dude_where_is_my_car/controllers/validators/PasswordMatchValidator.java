package com.innowise.dude_where_is_my_car.controllers.validators;

import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
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
