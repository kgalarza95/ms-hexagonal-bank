package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;


import java.util.List;
import java.util.Optional;

public class FindAccountUseCase {

    IAccountRepositoryGateway IAccountRepositoryGateway;

    public FindAccountUseCase(IAccountRepositoryGateway IAccountRepositoryGateway) {
        this.IAccountRepositoryGateway = IAccountRepositoryGateway;
    }

    public List<Account> execute() {
        List<Account> accounts = IAccountRepositoryGateway.findAll();
        return Optional.ofNullable(accounts)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("No accounts found"));
    }


}
