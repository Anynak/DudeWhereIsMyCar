package com.innowise.dude_where_is_my_car.exceptions;

public class AlreadyLoggedException extends RuntimeException {
    public AlreadyLoggedException(String message) {
        super(message);
    }
}
