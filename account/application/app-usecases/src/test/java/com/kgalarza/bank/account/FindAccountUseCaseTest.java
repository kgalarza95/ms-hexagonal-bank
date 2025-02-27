package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindAccountUseCaseTest {

    @Mock
    private IAccountRepositoryGateway IAccountRepositoryGateway;

    private FindAccountUseCase findAccountUseCase;
    private FindByIdAccountUseCase findByIdAccountUseCase;

    @BeforeEach
    void setUp() {
        findAccountUseCase = new FindAccountUseCase(IAccountRepositoryGateway);
        findByIdAccountUseCase = new FindByIdAccountUseCase(IAccountRepositoryGateway);
    }

    @Test
    void findAll_ShouldReturnListOfAccounts() {
        Account account1 = new Account(1L, "123456", "Checking", BigDecimal.valueOf(1000.0), true, 101L);
        Account account2 = new Account(2L, "654321", "Savings", BigDecimal.valueOf(2500.0), false, 102L);
        List<Account> accounts = Arrays.asList(account1, account2);
        Mockito.when(IAccountRepositoryGateway.findAll()).thenReturn(accounts);

        List<Account> result = findAccountUseCase.execute();

        Assertions.assertEquals(accounts, result);
        Mockito.verify(IAccountRepositoryGateway).findAll();
    }

    @Test
    void findById_ShouldReturnAccount_WhenAccountExists() {
        Account account = new Account(1L, "123456", "Checking", BigDecimal.valueOf(1000.0), true, 101L);
        Mockito.when(IAccountRepositoryGateway.findById(1L)).thenReturn(account);

        Account result = findByIdAccountUseCase.execute(1L);

        Assertions.assertEquals(account, result);
        Mockito.verify(IAccountRepositoryGateway).findById(1L);
    }

    @Test
    void findById_ShouldThrowResourceNotFoundException_WhenAccountDoesNotExist() {
        Mockito.when(IAccountRepositoryGateway.findById(99L)).thenReturn(null);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            findByIdAccountUseCase.execute(99L);
        });

        Mockito.verify(IAccountRepositoryGateway).findById(99L);
    }

}
