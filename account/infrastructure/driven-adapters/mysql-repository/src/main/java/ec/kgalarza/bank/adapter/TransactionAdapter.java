package ec.kgalarza.bank.adapter;

import com.kgalarza.bank.entity.AccountStatementReport;
import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;
import ec.kgalarza.bank.mapper.ReportRepoMapper;
import ec.kgalarza.bank.mapper.TransactionRepoMapper;
import ec.kgalarza.bank.model.entity.TransactionEntity;
import ec.kgalarza.bank.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionAdapter implements ITransactionRepositoryGateway {

    private final ITransactionRepository transactionRepository;

    public TransactionAdapter(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = TransactionRepoMapper.toEntity(transaction);
        return TransactionRepoMapper.toDTO(transactionRepository.save(transactionEntity));
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .map(TransactionRepoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionRepoMapper::toDTO)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAccountStatementReport(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.getAccountStatementReport(startDate, endDate)
                .stream()
                .map(ReportRepoMapper::toDomain)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAllAccountStatements() {
        return transactionRepository.getAllAccountStatements()
                .stream()
                .map(ReportRepoMapper::toDomain)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAccountStatementReportByUser(LocalDateTime startDate, LocalDateTime endDate, Long userId) {
        return transactionRepository.getAccountStatementReportByUser(startDate, endDate, userId)
                .stream()
                .map(ReportRepoMapper::toDomain)
                .toList();
    }
}
