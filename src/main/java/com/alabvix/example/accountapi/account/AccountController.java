package com.alabvix.example.accountapi.account;

import com.alabvix.example.accountapi.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);

    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody Transaction transaction){
        accountService.withdraw(transaction);

    }

    @PostMapping("/deposit")
    public void deposit(@RequestBody Transaction transaction){
        accountService.deposit(transaction);

    }

    @PostMapping("/loan")
    public void loan(@RequestBody Transaction transaction){
        accountService.loan(transaction);

    }
}
