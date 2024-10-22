package com.github.gilberto009199.picpay.controllers;

import com.github.gilberto009199.picpay.exceptions.InvalidTransactionException;
import com.github.gilberto009199.picpay.exceptions.UnathorizationTransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<?> handlerInvalidTransaction(InvalidTransactionException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UnathorizationTransactionException.class)
    public ResponseEntity<?> handlerUnathorizationTransactionException(UnathorizationTransactionException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }
}
