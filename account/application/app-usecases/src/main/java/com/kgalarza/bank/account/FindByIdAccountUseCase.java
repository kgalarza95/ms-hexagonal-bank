package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;

public class FindByIdAccountUseCase {

    private final IAccountRepositoryGateway accountRepositoryGateway;

    public FindByIdAccountUseCase(IAccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    public Account execute(Long id) {
        Account account = accountRepositoryGateway.findById(id);
        if (account == null){
            throw new ResourceNotFoundException("Account with id " + id + " not found");
        }
        return account;
    }
}
