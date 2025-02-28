package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.exception.AccountAlreadyExistsException;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;

import java.time.LocalDateTime;

public class UpdateAccountUseCase {

    private final IAccountRepositoryGateway accountRepositoryGateway;
    private final ILogBusMessageGateway logBusMessageGateway;

    public UpdateAccountUseCase(IAccountRepositoryGateway accountRepositoryGateway, ILogBusMessageGateway logBusMessageGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.logBusMessageGateway = logBusMessageGateway;
    }

    public Account execute(Account entidad) {
        Account account = accountRepositoryGateway.findByAccountNumber(entidad.getAccountNumber());
        if (account == null) {
            throw new ResourceNotFoundException("Account with number " + entidad.getAccountNumber() + " not found");
        }
        logBusMessageGateway.sendMessage(new Log("Account updated: " + entidad, LocalDateTime.now()));
        return accountRepositoryGateway.save(entidad);
    }

}
