package com.alabvix.example.accountapi.finance;

import com.alabvix.example.accountapi.transaction.Transaction;

public interface FinanceService {

    void validateAccountHolder(Integer accountHolderId) throws FinanceException;

    void validateLoan(Transaction transaction) throws FinanceException;
}
