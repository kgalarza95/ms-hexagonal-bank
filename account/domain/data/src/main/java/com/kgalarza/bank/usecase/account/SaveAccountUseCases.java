package com.kgalarza.bank.usecase.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.gateway.AccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;

import java.time.LocalDateTime;

public class SaveAccountUseCases {

    AccountRepositoryGateway accountRepositoryGateway;
    ILogBusMessageGateway iLogBusMessageGateway;

    public SaveAccountUseCases(AccountRepositoryGateway accountRepositoryGateway, ILogBusMessageGateway iLogBusMessageGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.iLogBusMessageGateway = iLogBusMessageGateway;
    }

    public Account save(Account entidad) {
        iLogBusMessageGateway.sendMessage(new Log("Account created: "+entidad, LocalDateTime.now()));
        return accountRepositoryGateway.save(entidad);
    }

}
