package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.AccountRepositoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindAccountUseCaseTest {

    @Mock
    private AccountRepositoryGateway accountRepositoryGateway;

    private FindAccountUseCase findAccountUseCase;

    @BeforeEach
    void setUp() {
        findAccountUseCase = new FindAccountUseCase(accountRepositoryGateway);
    }

    @Test
    void findAll_ShouldReturnListOfAccounts() {
        // Arrange
        Account account1 = new Account(1L, "123456", "Checking", 1000.0, true, 101L);
        Account account2 = new Account(2L, "654321", "Savings", 2500.0, false, 102L);
        List<Account> accounts = Arrays.asList(account1, account2);
        Mockito.when(accountRepositoryGateway.findAll()).thenReturn(accounts);

        // Act
        List<Account> result = findAccountUseCase.findAll();

        // Assert
        Assertions.assertEquals(accounts, result);
        Mockito.verify(accountRepositoryGateway).findAll();
    }

    @Test
    void findById_ShouldReturnAccount_WhenAccountExists() {
        // Arrange
        Account account = new Account(1L, "123456", "Checking", 1000.0, true, 101L);
        Mockito.when(accountRepositoryGateway.findById(1L)).thenReturn(account);

        // Act
        Account result = findAccountUseCase.findById(1L);

        // Assert
        Assertions.assertEquals(account, result);
        Mockito.verify(accountRepositoryGateway).findById(1L);
    }

    @Test
    void findById_ShouldReturnNull_WhenAccountDoesNotExist() {
        // Arrange
        Mockito.when(accountRepositoryGateway.findById(99L)).thenReturn(null);

        // Act
        Account result = findAccountUseCase.findById(99L);

        // Assert
        Assertions.assertNull(result);
        Mockito.verify(accountRepositoryGateway).findById(99L);
    }

}
