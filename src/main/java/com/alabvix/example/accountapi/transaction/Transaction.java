package com.alabvix.example.accountapi.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    public final TransactionType type;

    public final BigDecimal amount;

    public final LocalDate transactionTime;

    public final Integer accountId;

    public Transaction(TransactionType type, BigDecimal amount, LocalDate transactionTime, Integer accountId) {
        this.type = type;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.accountId = accountId;
    }
}
