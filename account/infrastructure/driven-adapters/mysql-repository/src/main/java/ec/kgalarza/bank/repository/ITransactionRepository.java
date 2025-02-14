package ec.kgalarza.bank.repository;

import ec.kgalarza.bank.model.dto.AccountStatementReportDto;
import ec.kgalarza.bank.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query("SELECT new ec.kgalarza.bank.model.dto.AccountStatementReportDto( " +
            "mv.transactionDate, cl.name, acc.accountNumber, acc.accountType, " +
            "mv.initialBalance, mv.transactionAmount, mv.availableBalance, " +
            "mv.transactionDescription, acc.status) " +
            "FROM CustomerEntity cl " +
            "JOIN AccountEntity acc ON cl.customerId = acc.customerId " +
            "JOIN TransactionEntity mv ON mv.account.id = acc.id " +
            "WHERE mv.transactionDate BETWEEN :startDate AND :endDate " +
            "AND acc.status = true " +
            "ORDER BY mv.transactionDate, acc.accountNumber")
    List<AccountStatementReportDto> getAccountStatementReport(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);


    @Query("SELECT new ec.kgalarza.bank.model.dto.AccountStatementReportDto( " +
            "mv.transactionDate, cl.name, acc.accountNumber, acc.accountType, " +
            "mv.initialBalance, mv.transactionAmount, mv.availableBalance, " +
            "mv.transactionDescription, acc.status) " +
            "FROM CustomerEntity cl " +
            "JOIN AccountEntity acc ON cl.customerId = acc.customerId " +
            "JOIN TransactionEntity mv ON mv.account.id = acc.id " +
            "ORDER BY mv.transactionDate, acc.accountNumber")
    List<AccountStatementReportDto> getAllAccountStatements();


    @Query("SELECT new ec.kgalarza.bank.model.dto.AccountStatementReportDto( " +
            "mv.transactionDate, cl.name, acc.accountNumber, acc.accountType, " +
            "mv.initialBalance, mv.transactionAmount, mv.availableBalance, " +
            "mv.transactionDescription, acc.status) " +
            "FROM CustomerEntity cl " +
            "JOIN AccountEntity acc ON cl.customerId = acc.customerId " +
            "JOIN TransactionEntity mv ON mv.account.id = acc.id " +
            "WHERE mv.transactionDate BETWEEN :startDate AND :endDate " +
            "AND acc.status = true " +
            "AND cl.customerId = :userId " +
            "ORDER BY mv.transactionDate, acc.accountNumber")
    List<AccountStatementReportDto> getAccountStatementReportByUser(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("userId") Long userId);


}

