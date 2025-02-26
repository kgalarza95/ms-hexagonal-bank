package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;

public class FindByIdAccountUseCase {

    private final IAccountRepositoryGateway iAccountRepositoryGateway;

    public FindByIdAccountUseCase(IAccountRepositoryGateway iAccountRepositoryGateway) {
        this.iAccountRepositoryGateway = iAccountRepositoryGateway;
    }

    public Account execute(Long id) {
        Account account = iAccountRepositoryGateway.findById(id);
        if (account == null){
            throw new ResourceNotFoundException("Account with id " + id + " not found");
        }
        return account;
    }
}
