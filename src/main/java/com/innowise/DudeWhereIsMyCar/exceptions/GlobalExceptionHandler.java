package com.innowise.DudeWhereIsMyCar.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Autowired
    @Qualifier("validationErrors")
    private MessageSource messageSource;

    private final Locale loc = LocaleContextHolder.getLocale();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);
    }

    private ResponseEntity<Object> createResponse(Exception ex, String errorText, HttpStatus httpStatus) {
        ApiError apiError = new ApiError(httpStatus, ex.getLocalizedMessage(), errorText);
        return new ResponseEntity<>(apiError, apiError.getStatus());
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


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return createResponse(ex, messageSource.getMessage("request.bad", null, loc), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknownExceptions(Exception ex) {
        return createResponse(ex, messageSource.getMessage("unknown.exception", null, loc), HttpStatus.BAD_REQUEST);
    }

}
