package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;

import java.util.List;


public class FindTransactionUseCase {

    private final ITransactionRepositoryGateway iTransactionRepositoryGateway;

    public FindTransactionUseCase(ITransactionRepositoryGateway iTransactionRepositoryGateway) {
        this.iTransactionRepositoryGateway = iTransactionRepositoryGateway;
    }

    public List<Transaction> execute() {
        return iTransactionRepositoryGateway.findAll();
    }

}
