package com.alabvix.example.accountapi.account;

import com.alabvix.example.accountapi.finance.FinanceService;
import com.alabvix.example.accountapi.limit.Limit;
import com.alabvix.example.accountapi.limit.LimitService;
import com.alabvix.example.accountapi.transaction.InvalidTransactionException;
import com.alabvix.example.accountapi.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final FinanceService financeService;

    private final LimitService limitService;

    private final AccountRepository accountRepository;

    public static final String INVALID_DEPOSIT_AMOUNT_MSG = "Invalid deposit amount";

    public static final String INVALID_WITHDRAW_AMOUNT_MSG = "Invalid withdraw amount";

    @Autowired
    public AccountService(FinanceService financeService,
                          LimitService limitService,
                          AccountRepository accountRepository) {
        this.financeService = financeService;
        this.limitService = limitService;
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account){

        financeService.validateAccountHolder(account.getAccountHolderId());

        accountRepository.save(account);

    }

    public void withdraw(Transaction transaction){
    }

    public void deposit(Transaction transaction){

        Limit limit = limitService.getLimitByAccount(transaction.accountId);

        if (transaction.amount.compareTo(limit.amount) > 0) {
            throw new InvalidTransactionException(INVALID_DEPOSIT_AMOUNT_MSG);
        }

        Account account = accountRepository.findById(transaction.accountId);
        account.setBalance(account.getBalance().add(transaction.amount));

        accountRepository.save(account);
    }

    public void loan(Transaction transaction){

        financeService.validateLoan(transaction);

        Account account = accountRepository.findById(transaction.accountId);
        account.setBalance(account.getBalance().add(transaction.amount));

        accountRepository.save(account);

    }

}
