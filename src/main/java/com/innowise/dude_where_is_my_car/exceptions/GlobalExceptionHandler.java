package com.innowise.dude_where_is_my_car.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {


    private final Locale loc = LocaleContextHolder.getLocale();
    @Autowired
    @Qualifier("validationErrors")
    private MessageSource messageSource;

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleBind(Exception ex) {
        BindingResult bindingResult = (BindingResult) ex;
        List<ApiError> apiErrors = new ArrayList<>();

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String userMessage = fieldError.getField() + " " + fieldError.getDefaultMessage();
            ApiError apiError = new ApiError(userMessage, userMessage);
            apiErrors.add(apiError);
        }
        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            String userMessage = objectError.getDefaultMessage();
            ApiError apiError = new ApiError(userMessage, userMessage);
            apiErrors.add(apiError);
        }
        return new ResponseEntity<>(apiErrors, httpStatus);
    }

    private ResponseEntity<Object> createResponse(Exception ex, String errorText, HttpStatus httpStatus) {
        ApiError apiError = new ApiError(ex.getMessage(), errorText);
        List<ApiError> errors = new ArrayList<>();
        errors.add(apiError);
        return new ResponseEntity<>(errors, httpStatus);
    }

    @ExceptionHandler(AlreadyLoggedException.class)
    public ResponseEntity<Object> handleAlreadyLoggedException(Exception ex) {
        return createResponse(ex, messageSource.getMessage("user.login.AlreadyLogged", null, loc), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsException(Exception ex) {
        return createResponse(ex, messageSource.getMessage("user.registration.alreadyExists", null, loc), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(Exception ex) {
        return createResponse(ex, messageSource.getMessage("user.registration.email.exists", null, loc), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
    public ResponseEntity<Object> handlePhoneAlreadyExistsException(Exception ex) {
        return createResponse(ex, messageSource.getMessage("user.registration.phone.exists", null, loc), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(Exception ex) {
        return createResponse(ex, messageSource.getMessage("resource.notFound", null, loc), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUsernameNotFoundException(Exception ex) {
        return createResponse(ex, messageSource.getMessage("user.login.notFound", null, loc), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return createResponse(ex, messageSource.getMessage("request.bad", null, loc), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknownExceptions(Exception ex) {
        return createResponse(ex, messageSource.getMessage("unknown.exception", null, loc), HttpStatus.BAD_REQUEST);
    }

}
