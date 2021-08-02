package com.alabvix.example.accountapi.account;

import com.alabvix.example.accountapi.finance.FinanceService;
import com.alabvix.example.accountapi.limit.Limit;
import com.alabvix.example.accountapi.limit.LimitService;
import com.alabvix.example.accountapi.transaction.InvalidTransactionException;
import com.alabvix.example.accountapi.transaction.Transaction;
import com.alabvix.example.accountapi.transaction.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountServiceUnitTest {

    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private FinanceService financeService;

    @Mock
    private LimitService limitService;

    @BeforeEach
    public void beforeEach() {
        // Runs before each method. For each method an instance of the test class will be created.
        MockitoAnnotations.openMocks(this);
        accountService = new AccountService(financeService, limitService, accountRepository);
    }

    @Test
    @DisplayName("Given a deposit with amount below the limit should be successful")
    public void deposit_amount_below_limit(){

        // given
        Transaction transaction = new Transaction(
                TransactionType.DEPOSIT,
                BigDecimal.valueOf(100),
                LocalDate.now(),
                1);

        Account account = new Account(1, 1, BigDecimal.valueOf(1000));
        Limit limit = new Limit(1, BigDecimal.valueOf(2000));

        when(limitService.getLimitByAccount(1)).thenReturn(limit);
        when(accountRepository.findById(1)).thenReturn(account);

        // when
        accountService.deposit(transaction);

        // then
        verify(accountRepository, times(1)).save(account);
        assertEquals(1100, account.getBalance().intValue());

    }

    @Test
    @DisplayName("Given a deposit with amount equal the limit should be successful")
    public void deposit_amount_equal_limit(){

        // given
        Transaction transaction = new Transaction(
                TransactionType.DEPOSIT,
                BigDecimal.valueOf(2000),
                LocalDate.now(),
                1);

        Account account = new Account(1, 1, BigDecimal.valueOf(1000));
        Limit limit = new Limit(1, BigDecimal.valueOf(2000));

        when(limitService.getLimitByAccount(1)).thenReturn(limit);
        when(accountRepository.findById(1)).thenReturn(account);

        // when
        accountService.deposit(transaction);

        // then
        verify(accountRepository, times(1)).save(account);
        assertEquals(3000, account.getBalance().intValue());

    }

    @Test
    @DisplayName("Given an over limit deposit must throws an InvalidTransactionException")
    public void deposit_over_limit_should_throws_exception(){

        // given
        Transaction transaction = new Transaction(
                TransactionType.DEPOSIT,
                BigDecimal.valueOf(2000.99),
                LocalDate.now(),
                1);

        Account account = new Account(1, 1, BigDecimal.valueOf(1000));
        Limit limit = new Limit(1, BigDecimal.valueOf(2000));

        when(limitService.getLimitByAccount(1)).thenReturn(limit);
        when(accountRepository.findById(1)).thenReturn(account);

        // then
        Exception ex = Assertions.assertThrows(InvalidTransactionException.class, () -> {
            // when
            accountService.deposit(transaction);
        });

        // then
        assertEquals(AccountService.INVALID_DEPOSIT_AMOUNT_MSG, ex.getMessage());
        verify(accountRepository, times(0)).save(account);

    }

    @Test
    @DisplayName("Given an over limit withdraw must throws an InvalidTransactionException")
    public void withdraw_given_amount_over_limit_should_throws_Exception(){

        assertEquals(true, false);

    }

    @Test
    @DisplayName("Given a valid amount the withdraw operation must be successful")
    public void withdraw_given_valid_amount_should_complete_without_errors(){

        assertEquals(true, false);

    }

}
