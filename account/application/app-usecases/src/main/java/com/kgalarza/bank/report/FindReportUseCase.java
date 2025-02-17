package com.kgalarza.bank.report;

import com.kgalarza.bank.entity.AccountStatementReport;
import com.kgalarza.bank.gateway.TransactionRepositoryGateway;

import java.time.LocalDateTime;
import java.util.List;

public class FindReportUseCase {

    private final TransactionRepositoryGateway transactionRepositoryGateway;

    public FindReportUseCase(TransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public List<AccountStatementReport> getAccountStatementReport(
            LocalDateTime startDate,
            LocalDateTime endDate) {
        return transactionRepositoryGateway.getAccountStatementReport(startDate, endDate);
    }

    public List<AccountStatementReport> getAllAccountStatements() {
        return transactionRepositoryGateway.getAllAccountStatements();
    }

    public List<AccountStatementReport> getAccountStatementReportByUser(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Long userId) {
        return transactionRepositoryGateway.getAccountStatementReportByUser(startDate, endDate, userId);
    }
}
