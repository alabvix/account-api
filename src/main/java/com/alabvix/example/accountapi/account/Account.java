package com.alabvix.example.accountapi.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Account {

    private Integer accountId;

    /** Id do correntista */
    private Integer accountHolderId;

    /** Saldo da conta */
    private BigDecimal balance;

}
