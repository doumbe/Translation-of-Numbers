package com.test.translator.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LangueTranslateBadRequestException extends RuntimeException{

    public LangueTranslateBadRequestException(String message) {
        super(message);
    }
}


