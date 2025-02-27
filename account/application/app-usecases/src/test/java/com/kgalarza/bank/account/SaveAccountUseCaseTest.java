package com.kgalarza.bank.account;


import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SaveAccountUseCaseTest {
    @Mock
    private IAccountRepositoryGateway IAccountRepositoryGateway;

    @Mock
    private ILogBusMessageGateway iLogBusMessageGateway;

    private SaveAccountUseCase saveAccountUseCase;

    @BeforeEach
    void setUp() {
        saveAccountUseCase = new SaveAccountUseCase(IAccountRepositoryGateway, iLogBusMessageGateway);
    }

    @Test
    void save_ShouldReturnSavedAccount_AndSendLogMessage() {
        Account accountToSave = new Account(1L, "123456", "Checking", BigDecimal.valueOf(1000.0), true, 101L);
        Mockito.when(IAccountRepositoryGateway.save(accountToSave)).thenReturn(accountToSave);

        Account result = saveAccountUseCase.execute(accountToSave);

        Mockito.verify(IAccountRepositoryGateway).save(accountToSave);

        Mockito.verify(iLogBusMessageGateway).sendMessage(any(Log.class));

        Assertions.assertEquals(accountToSave, result);
    }
}
