package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;

import java.time.LocalDateTime;

public class SaveAccountUseCase {

    IAccountRepositoryGateway IAccountRepositoryGateway;
    ILogBusMessageGateway iLogBusMessageGateway;

    public SaveAccountUseCase(IAccountRepositoryGateway IAccountRepositoryGateway, ILogBusMessageGateway iLogBusMessageGateway) {
        this.IAccountRepositoryGateway = IAccountRepositoryGateway;
        this.iLogBusMessageGateway = iLogBusMessageGateway;
    }

    public Account execute(Account entidad) {
        iLogBusMessageGateway.sendMessage(new Log("Account created: "+entidad, LocalDateTime.now()));
        return IAccountRepositoryGateway.save(entidad);
    }

}
