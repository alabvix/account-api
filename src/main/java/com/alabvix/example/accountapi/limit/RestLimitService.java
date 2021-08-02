package com.alabvix.example.accountapi.limit;

import org.springframework.stereotype.Service;

@Service
public class RestLimitService implements LimitService{

    @Override
    public Limit getLimitByAccount(Integer AccountId) throws LimitException {
        return null;
    }
}
