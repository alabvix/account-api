package com.alabvix.example.accountapi.limit;

public class LimitException extends RuntimeException{
    public LimitException(String msg) {
        super(msg);
    }
}
