package com.kgalarza.bank.transaction;

import com.kgalarza.bank.account.FindAccountUseCase;
import com.kgalarza.bank.account.FindByIdAccountUseCase;
import com.kgalarza.bank.account.SaveAccountUseCase;
import com.kgalarza.bank.account.UpdateAccountUseCase;
import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.exception.GeneralAccountValidationException;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class SaveTransactionUseCase {

    private final ITransactionRepositoryGateway transactionRepositoryGateway;
    private final FindByIdAccountUseCase  findByIdAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final ILogBusMessageGateway logBusMessageGateway;

    public SaveTransactionUseCase(ITransactionRepositoryGateway transactionRepositoryGateway, FindByIdAccountUseCase findByIdAccountUseCase, UpdateAccountUseCase updateAccountUseCase, ILogBusMessageGateway logBusMessageGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
        this.findByIdAccountUseCase = findByIdAccountUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
        this.logBusMessageGateway = logBusMessageGateway;
    }

    public Transaction execute(Transaction entidad) {
        Account account = Optional.ofNullable(findByIdAccountUseCase.execute(entidad.getAccountId()))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + entidad.getAccountId()));

        BigDecimal finalBalance = Optional.of(account.getOnlineBalance().add(entidad.getTransactionAmount()))
                .filter(balance -> balance.compareTo(BigDecimal.ZERO) >= 0)
                .orElseThrow(() -> new GeneralAccountValidationException("Balance not available"));

        entidad.setInitialBalance(account.getOnlineBalance());
        entidad.setAvailableBalance(finalBalance);
        entidad.setTransactionDescription(entidad.getTransactionAmount().compareTo(BigDecimal.ZERO) < 0
                ? "Withdrawal of " + entidad.getTransactionAmount().abs()
                : "Deposit of " + entidad.getTransactionAmount());
        entidad.setTransactionDate(LocalDateTime.now());

        Transaction savedTransaction = transactionRepositoryGateway.save(entidad);

        account.setOnlineBalance(finalBalance);
        updateAccountUseCase.execute(account);

        logBusMessageGateway.sendMessage(new Log("Transaction created: "+entidad, LocalDateTime.now()));
        return savedTransaction;
    }



}
