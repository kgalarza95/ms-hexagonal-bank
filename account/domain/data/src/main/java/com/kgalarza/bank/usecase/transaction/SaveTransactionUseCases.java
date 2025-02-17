package com.kgalarza.bank.usecase.transaction;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.exception.GeneralAccountValidationException;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;
import com.kgalarza.bank.gateway.TransactionRepositoryGateway;
import com.kgalarza.bank.usecase.account.FindAccountUseCases;
import com.kgalarza.bank.usecase.account.SaveAccountUseCases;

import java.time.LocalDateTime;

public class SaveTransactionUseCases {

    TransactionRepositoryGateway transactionRepositoryGateway;
    FindAccountUseCases findAccountUseCases;
    SaveAccountUseCases saveAccountUseCases;
    ILogBusMessageGateway iLogBusMessageGateway;

    public SaveTransactionUseCases(TransactionRepositoryGateway transactionRepositoryGateway, FindAccountUseCases findAccountUseCases, SaveAccountUseCases saveAccountUseCases, ILogBusMessageGateway iLogBusMessageGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
        this.findAccountUseCases = findAccountUseCases;
        this.saveAccountUseCases = saveAccountUseCases;
        this.iLogBusMessageGateway = iLogBusMessageGateway;
    }

    public Transaction save(Transaction entidad) {
        Account account = findAccountUseCases.findById(entidad.getAccountId());

        if (account == null) {
            throw new ResourceNotFoundException("Account not found with id: " + entidad.getAccountId());
        }

        double finalBalance = account.getOnlineBalance() + entidad.getTransactionAmount();

        if (finalBalance < 0) {
            throw new GeneralAccountValidationException("Balance not available");
        }

        entidad.setInitialBalance(account.getOnlineBalance());
        entidad.setAvailableBalance(finalBalance);
        entidad.setTransactionDescription(entidad.getTransactionAmount() < 0
                ? "Withdrawal of " + (entidad.getTransactionAmount() * -1)
                : "Deposit of " + entidad.getTransactionAmount());
        entidad.setTransactionDate(LocalDateTime.now());

        Transaction savedTransaction = transactionRepositoryGateway.save(entidad);

        account.setOnlineBalance(finalBalance);
        saveAccountUseCases.save(account);

        iLogBusMessageGateway.sendMessage(new Log("Transaction created: "+entidad, LocalDateTime.now()));
        return savedTransaction;
    }


}
