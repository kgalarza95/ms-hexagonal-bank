package com.kgalarza.bank.transaction;

import com.kgalarza.bank.account.FindAccountUseCase;
import com.kgalarza.bank.account.FindByIdAccountUseCase;
import com.kgalarza.bank.account.SaveAccountUseCase;
import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.exception.GeneralAccountValidationException;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;


import java.time.LocalDateTime;
import java.util.Optional;

public class SaveTransactionUseCase {

    private final ITransactionRepositoryGateway iTransactionRepositoryGateway;
    private final FindAccountUseCase findAccountUseCases;
    private final FindByIdAccountUseCase  findByIdAccountUseCase;
    private final SaveAccountUseCase saveAccountUseCases;
    private final ILogBusMessageGateway iLogBusMessageGateway;

    public SaveTransactionUseCase(ITransactionRepositoryGateway iTransactionRepositoryGateway, FindAccountUseCase findAccountUseCases, FindByIdAccountUseCase findByIdAccountUseCase, SaveAccountUseCase saveAccountUseCases, ILogBusMessageGateway iLogBusMessageGateway) {
        this.iTransactionRepositoryGateway = iTransactionRepositoryGateway;
        this.findAccountUseCases = findAccountUseCases;
        this.findByIdAccountUseCase = findByIdAccountUseCase;
        this.saveAccountUseCases = saveAccountUseCases;
        this.iLogBusMessageGateway = iLogBusMessageGateway;
    }

    public Transaction execute(Transaction entidad) {
        Account account = Optional.ofNullable(findByIdAccountUseCase.execute(entidad.getAccountId()))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + entidad.getAccountId()));

        double finalBalance = Optional.of(account.getOnlineBalance() + entidad.getTransactionAmount())
                .filter(balance -> balance >= 0)
                .orElseThrow(() -> new GeneralAccountValidationException("Balance not available"));

        entidad.setInitialBalance(account.getOnlineBalance());
        entidad.setAvailableBalance(finalBalance);
        entidad.setTransactionDescription(entidad.getTransactionAmount() < 0
                ? "Withdrawal of " + (entidad.getTransactionAmount() * -1)
                : "Deposit of " + entidad.getTransactionAmount());
        entidad.setTransactionDate(LocalDateTime.now());

        Transaction savedTransaction = iTransactionRepositoryGateway.save(entidad);

        account.setOnlineBalance(finalBalance);
        saveAccountUseCases.execute(account);

        iLogBusMessageGateway.sendMessage(new Log("Transaction created: "+entidad, LocalDateTime.now()));
        return savedTransaction;
    }


}
