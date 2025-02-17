package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.TransactionRepositoryGateway;

import java.util.List;


public class FindTransactionUseCase {

    TransactionRepositoryGateway transactionRepositoryGateway;

    public FindTransactionUseCase(TransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public List<Transaction> findAll() {
        return transactionRepositoryGateway.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepositoryGateway.findById(id);
    }
}
