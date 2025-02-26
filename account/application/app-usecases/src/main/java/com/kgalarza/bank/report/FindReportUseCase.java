package com.kgalarza.bank.report;

import com.kgalarza.bank.entity.AccountStatementReport;
import com.kgalarza.bank.exception.ResourceNotFoundException;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

public class FindReportUseCase {

    private final ITransactionRepositoryGateway iTransactionRepositoryGateway;

    public FindReportUseCase(ITransactionRepositoryGateway iTransactionRepositoryGateway) {
        this.iTransactionRepositoryGateway = iTransactionRepositoryGateway;
    }

    public List<AccountStatementReport> getAccountStatementReport(LocalDateTime startDate, LocalDateTime endDate) {
        return getNonEmptyList(() -> iTransactionRepositoryGateway.getAccountStatementReport(startDate, endDate), "No account statements found for the given period");
    }

    public List<AccountStatementReport> getAllAccountStatements() {
        return getNonEmptyList(() -> iTransactionRepositoryGateway.getAllAccountStatements(), "No account statements found");
    }

    public List<AccountStatementReport> getAccountStatementReportByUser(LocalDateTime startDate, LocalDateTime endDate, Long userId) {
        return getNonEmptyList(() -> iTransactionRepositoryGateway.getAccountStatementReportByUser(startDate, endDate, userId), "No account statements found for user with ID: " + userId);
    }

    private List<AccountStatementReport> getNonEmptyList(Supplier<List<AccountStatementReport>> supplier, String errorMessage) {
        List<AccountStatementReport> result = supplier.get();
        if (result.isEmpty()) {
            throw new ResourceNotFoundException(errorMessage);
        }
        return result;
    }

}
