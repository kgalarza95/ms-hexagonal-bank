package com.kgalarza.bank.gateway;

import com.kgalarza.bank.entity.AccountStatementReport;
import com.kgalarza.bank.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionRepositoryGateway {
    Transaction save(Transaction transaction);

    Transaction findById(Long id);

    List<Transaction> findAll();


    List<AccountStatementReport> getAccountStatementReport(
            LocalDateTime startDate,
            LocalDateTime endDate);

    List<AccountStatementReport> getAllAccountStatements();

    List<AccountStatementReport> getAccountStatementReportByUser(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Long userId);

}
