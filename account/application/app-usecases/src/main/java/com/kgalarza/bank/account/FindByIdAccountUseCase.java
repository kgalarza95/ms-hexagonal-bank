package com.kgalarza.bank.account;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;

import java.util.List;

public class FindByIdAccountUseCase {

    IAccountRepositoryGateway IAccountRepositoryGateway;

    public FindByIdAccountUseCase(IAccountRepositoryGateway IAccountRepositoryGateway) {
        this.IAccountRepositoryGateway = IAccountRepositoryGateway;
    }

    public Account execute(Long id) {
        return IAccountRepositoryGateway.findById(id);
    }
}
