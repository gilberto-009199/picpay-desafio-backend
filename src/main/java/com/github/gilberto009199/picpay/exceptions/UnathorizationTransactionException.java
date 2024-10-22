package com.github.gilberto009199.picpay.exceptions;

public class UnathorizationTransactionException extends RuntimeException{
    public UnathorizationTransactionException(String message){
        super(message);
    }
}
