package com.alabvix.example.accountapi.account;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository{
    @Override
    public void save(Account account) {

    }

    @Override
    public Account findById(Integer id) {
        return null;
    }
}
