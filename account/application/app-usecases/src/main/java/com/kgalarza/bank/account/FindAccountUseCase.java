package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;


import java.util.List;

public class FindAccountUseCase {

    IAccountRepositoryGateway IAccountRepositoryGateway;

    public FindAccountUseCase(IAccountRepositoryGateway IAccountRepositoryGateway) {
        this.IAccountRepositoryGateway = IAccountRepositoryGateway;
    }

    public List<Account> execute() {
        return IAccountRepositoryGateway.findAll();
    }

}
