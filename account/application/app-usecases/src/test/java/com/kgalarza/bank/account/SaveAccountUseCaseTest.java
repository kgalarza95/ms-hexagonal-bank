package com.kgalarza.bank.account;


import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.gateway.AccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SaveAccountUseCaseTest {
    @Mock
    private AccountRepositoryGateway accountRepositoryGateway;

    @Mock
    private ILogBusMessageGateway iLogBusMessageGateway;

    private SaveAccountUseCase saveAccountUseCase;

    @BeforeEach
    void setUp() {
        saveAccountUseCase = new SaveAccountUseCase(accountRepositoryGateway, iLogBusMessageGateway);
    }

    @Test
    void save_ShouldReturnSavedAccount_AndSendLogMessage() {
        Account accountToSave = new Account(1L, "123456", "Checking", 1000.0, true, 101L);
        Mockito.when(accountRepositoryGateway.save(accountToSave)).thenReturn(accountToSave);

        Account result = saveAccountUseCase.save(accountToSave);

        Mockito.verify(accountRepositoryGateway).save(accountToSave);

        Mockito.verify(iLogBusMessageGateway).sendMessage(any(Log.class));

        Assertions.assertEquals(accountToSave, result);
    }
}
