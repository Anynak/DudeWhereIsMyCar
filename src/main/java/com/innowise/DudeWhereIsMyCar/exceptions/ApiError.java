package com.innowise.DudeWhereIsMyCar.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private String error;
    private String userMessage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ApiError(HttpStatus status, String error, String userMessage) {
        super();
        this.userMessage = userMessage;
        this.error = error;
        timestamp = LocalDateTime.now();
    }


}
