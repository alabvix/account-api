package com.alabvix.example.accountapi.account;

public interface AccountRepository  {

    void save(Account account);

    Account findById(Integer id);

}
