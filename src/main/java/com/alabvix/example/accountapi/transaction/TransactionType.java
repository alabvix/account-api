package com.alabvix.example.accountapi.transaction;

public enum TransactionType {

    WITHDRAW(1),  // Saque
    DEPOSIT(2),   // Depósito
    LOAN(3),      // Empréstimo
    TRANSFER(4);  // Transferencia

    private int transactionType;

    TransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

}
