package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;

import java.util.List;


public class FindByIdTransactionUseCase {

    ITransactionRepositoryGateway ITransactionRepositoryGateway;

    public FindByIdTransactionUseCase(ITransactionRepositoryGateway ITransactionRepositoryGateway) {
        this.ITransactionRepositoryGateway = ITransactionRepositoryGateway;
    }

    public Transaction execute(Long id) {
        return ITransactionRepositoryGateway.findById(id);
    }
}
