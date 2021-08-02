package com.alabvix.example.accountapi.finance;

import com.alabvix.example.accountapi.transaction.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RestFinanceService implements FinanceService{
    @Override
    public void validateAccountHolder(Integer accountHolderId) throws FinanceException {

    }

    @Override
    public void validateLoan(Transaction transaction) throws FinanceException {

    }
}
