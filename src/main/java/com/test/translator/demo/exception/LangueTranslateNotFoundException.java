package com.test.translator.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LangueTranslateNotFoundException extends RuntimeException {

    public LangueTranslateNotFoundException(String message) {
        super(message);
    }

}