package com.alabvix.example.accountapi.transaction;

public class InvalidTransactionException extends RuntimeException{
    public InvalidTransactionException(String msg) {
        super(msg);
    }
}
