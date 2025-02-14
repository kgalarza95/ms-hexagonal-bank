package com.kgalarza.bank.usecase.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.AccountRepositoryGateway;

import java.util.List;

public class FindAccountUseCase {

    AccountRepositoryGateway accountRepositoryGateway;

    public FindAccountUseCase(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    public List<Account> findAll() {
        return accountRepositoryGateway.findAll();
    }

    public Account findById(Long id) {
        return accountRepositoryGateway.findById(id);
    }
}
