package com.kgalarza.bank.usecase.transaction;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.AccountRepositoryGateway;
import com.kgalarza.bank.gateway.TransactionRepositoryGateway;

public class SaveTransactionUseCase {

    TransactionRepositoryGateway transactionRepositoryGateway;

    public SaveTransactionUseCase(TransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public Transaction save(Transaction entidad) {
        return transactionRepositoryGateway.save(entidad);
    }

}
