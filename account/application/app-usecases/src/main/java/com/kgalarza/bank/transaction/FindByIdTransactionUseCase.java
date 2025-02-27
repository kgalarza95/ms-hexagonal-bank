package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;


public class FindByIdTransactionUseCase {

    private final ITransactionRepositoryGateway transactionRepositoryGateway;

    public FindByIdTransactionUseCase(ITransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public Transaction execute(Long id) {
        Transaction transaction = transactionRepositoryGateway.findById(id);
        if (transaction == null) {
            throw new ResourceNotFoundException("Transaction with id " + id + " not found");
        }
        return transaction;
    }

}
