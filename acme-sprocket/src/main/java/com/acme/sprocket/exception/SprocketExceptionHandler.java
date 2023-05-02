package com.acme.sprocket.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SprocketExceptionHandler {
    @ExceptionHandler({ SprocketNotFoundException.class })
    public ResponseEntity<Object> handleSprocketNotFound(SprocketNotFoundException snfe) {
        ApiError apiError =
                new ApiError(HttpStatus.NOT_FOUND, snfe.getLocalizedMessage(), snfe.toString());

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
