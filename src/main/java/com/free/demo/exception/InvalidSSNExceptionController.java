package com.free.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidSSNExceptionController {
    @ExceptionHandler(value = InvalidSSNException.class)
    public ResponseEntity<Object> exception(InvalidSSNException exception) {
        return new ResponseEntity<>("Invalid Input", HttpStatus.BAD_REQUEST);
    }
}