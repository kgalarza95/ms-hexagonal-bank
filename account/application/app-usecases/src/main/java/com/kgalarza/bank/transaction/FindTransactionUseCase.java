package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;

import java.util.List;


public class FindTransactionUseCase {

    private final ITransactionRepositoryGateway transactionRepositoryGateway;

    public FindTransactionUseCase(ITransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public List<Transaction> execute() {
        List<Transaction> transactions = transactionRepositoryGateway.findAll();
        if (transactions == null || transactions.isEmpty()) {
            throw new ResourceNotFoundException("No transactions found");
        }
        return transactions;
    }


}
