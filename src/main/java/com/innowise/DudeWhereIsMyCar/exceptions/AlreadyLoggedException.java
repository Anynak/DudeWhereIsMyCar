package com.innowise.DudeWhereIsMyCar.exceptions;

public class AlreadyLoggedException extends RuntimeException {
    public AlreadyLoggedException(String message) {
        super(message);
    }
}
