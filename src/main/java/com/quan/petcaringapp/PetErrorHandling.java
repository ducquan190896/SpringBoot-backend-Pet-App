package com.quan.petcaringapp;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.quan.petcaringapp.Exception.EntityNotFoundException;
import com.quan.petcaringapp.Exception.ErrorResponse;

@ControllerAdvice
public class PetErrorHandling {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorResponse err = new ErrorResponse(ex.getMessage(), ex, LocalDateTime.now());

        return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<Object> handleNotValid(MethodArgumentNotValidException ex) {
        ErrorResponse err = new ErrorResponse(ex.getMessage(), ex, LocalDateTime.now());
        return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
    }
}
