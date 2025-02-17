package com.kgalarza.bank.usecase.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.TransactionRepositoryGateway;

import java.util.List;


public class FindTransactionUseCases {

    TransactionRepositoryGateway transactionRepositoryGateway;

    public FindTransactionUseCases(TransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public List<Transaction> findAll() {
        return transactionRepositoryGateway.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepositoryGateway.findById(id);
    }
}
