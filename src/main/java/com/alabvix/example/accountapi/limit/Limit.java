package com.alabvix.example.accountapi.limit;

import java.math.BigDecimal;

public class Limit {

    public final Integer accountId;

    public final BigDecimal amount;

    public Limit(Integer accountId, BigDecimal amount) {
        this.accountId = accountId;
        this.amount= amount;
    }
}
