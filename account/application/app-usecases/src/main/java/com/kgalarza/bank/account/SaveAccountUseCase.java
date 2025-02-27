package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.exception.AccountAlreadyExistsException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;

import java.time.LocalDateTime;

public class SaveAccountUseCase {

    private final IAccountRepositoryGateway accountRepositoryGateway;
    private final ILogBusMessageGateway logBusMessageGateway;

    public SaveAccountUseCase(IAccountRepositoryGateway accountRepositoryGateway, ILogBusMessageGateway logBusMessageGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.logBusMessageGateway = logBusMessageGateway;
    }

    public Account execute(Account entidad) {
        Account account = accountRepositoryGateway.findByAccountNumber(entidad.getAccountNumber());
        if (account != null){
            throw new AccountAlreadyExistsException("The account with number " + entidad.getAccountNumber()+ " already exists.");
        }
        logBusMessageGateway.sendMessage(new Log("Account created: "+entidad, LocalDateTime.now()));
        return accountRepositoryGateway.save(entidad);
    }

}
