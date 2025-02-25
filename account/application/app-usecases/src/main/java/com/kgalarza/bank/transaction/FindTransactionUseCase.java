package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;

import java.util.List;


public class FindTransactionUseCase {

    ITransactionRepositoryGateway ITransactionRepositoryGateway;

    public FindTransactionUseCase(ITransactionRepositoryGateway ITransactionRepositoryGateway) {
        this.ITransactionRepositoryGateway = ITransactionRepositoryGateway;
    }

    public List<Transaction> execute() {
        return ITransactionRepositoryGateway.findAll();
    }

}
