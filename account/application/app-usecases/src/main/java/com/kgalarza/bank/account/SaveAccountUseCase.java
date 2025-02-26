package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.exception.AccountAlreadyExistsException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;

import java.time.LocalDateTime;

public class SaveAccountUseCase {

    private final IAccountRepositoryGateway iAccountRepositoryGateway;
    private final ILogBusMessageGateway iLogBusMessageGateway;

    public SaveAccountUseCase(IAccountRepositoryGateway iAccountRepositoryGateway, ILogBusMessageGateway iLogBusMessageGateway) {
        this.iAccountRepositoryGateway = iAccountRepositoryGateway;
        this.iLogBusMessageGateway = iLogBusMessageGateway;
    }

    public Account execute(Account entidad) {
        Account account = iAccountRepositoryGateway.findByAccountNumber(entidad.getAccountNumber());
        if (account != null){
            throw new AccountAlreadyExistsException("The account with number " + entidad.getAccountNumber()+ " already exists.");
        }
        iLogBusMessageGateway.sendMessage(new Log("Account created: "+entidad, LocalDateTime.now()));
        return iAccountRepositoryGateway.save(entidad);
    }

}
