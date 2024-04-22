package com.sunrise.sunriseapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(RecordNotFoundException ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .body(ex.getMessage())
                .localTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
