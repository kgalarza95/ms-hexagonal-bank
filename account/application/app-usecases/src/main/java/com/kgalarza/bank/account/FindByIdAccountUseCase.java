package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;

import java.util.List;

public class FindByIdAccountUseCase {

    IAccountRepositoryGateway IAccountRepositoryGateway;

    public FindByIdAccountUseCase(IAccountRepositoryGateway IAccountRepositoryGateway) {
        this.IAccountRepositoryGateway = IAccountRepositoryGateway;
    }

    public Account execute(Long id) {
        Account account = IAccountRepositoryGateway.findById(id);
        if (account == null){
            throw new ResourceNotFoundException("Account with id " + id + " not found");
        }
        return account;
    }
}
