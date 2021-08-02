package com.alabvix.example.accountapi.limit;

public interface LimitService {

    Limit getLimitByAccount(Integer AccountId) throws LimitException;

}
