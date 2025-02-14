package com.kgalarza.bank.usecase.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.AccountRepositoryGateway;

public class SaveAccountUseCase {

    AccountRepositoryGateway accountRepositoryGateway;

    public SaveAccountUseCase(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    public Account save(Account entidad) {
        return accountRepositoryGateway.save(entidad);
    }

}
