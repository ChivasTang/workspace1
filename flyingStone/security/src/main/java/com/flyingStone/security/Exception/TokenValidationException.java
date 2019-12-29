package com.flyingStone.security.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TokenValidationException extends RuntimeException{
    private static final long serialVersionUID = 4851263066418481993L;

    private final String message;
    private final HttpStatus httpStatus;

    public TokenValidationException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
