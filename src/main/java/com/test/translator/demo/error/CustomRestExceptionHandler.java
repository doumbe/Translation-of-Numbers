package com.test.translator.demo.error;

import com.test.translator.demo.exception.LangueTranslateNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LangueTranslateNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            LangueTranslateNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), "error occured from resource");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
