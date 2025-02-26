package com.kgalarza.bank.transaction;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;


public class FindByIdTransactionUseCase {

    private final ITransactionRepositoryGateway iTransactionRepositoryGateway;

    public FindByIdTransactionUseCase(ITransactionRepositoryGateway iTransactionRepositoryGateway) {
        this.iTransactionRepositoryGateway = iTransactionRepositoryGateway;
    }

    public Transaction execute(Long id) {
        Transaction transaction = iTransactionRepositoryGateway.findById(id);
        if (transaction == null) {
            throw new ResourceNotFoundException("Transaction with id " + id + " not found");
        }
        return transaction;
    }

}
