package ec.kgalarza.bank.adapter;

import com.kgalarza.bank.entity.AccountStatementReport;
import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.ITransactionRepositoryGateway;
import ec.kgalarza.bank.mapper.IReportRepoMapper;
import ec.kgalarza.bank.mapper.ITransactionRepoMapper;
import ec.kgalarza.bank.model.entity.TransactionEntity;
import ec.kgalarza.bank.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionAdapter implements ITransactionRepositoryGateway {

    private final ITransactionRepository transactionRepository;
    private final IReportRepoMapper reportRepoMapper;
    private final ITransactionRepoMapper transactionRepoMapper;

    public TransactionAdapter(ITransactionRepository transactionRepository, IReportRepoMapper reportRepoMapper, ITransactionRepoMapper transactionRepoMapper) {
        this.transactionRepository = transactionRepository;
        this.reportRepoMapper = reportRepoMapper;
        this.transactionRepoMapper = transactionRepoMapper;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = transactionRepoMapper.toEntity(transaction);
        return transactionRepoMapper.toDTO(transactionRepository.save(transactionEntity));
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .map(transactionRepoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionRepoMapper::toDTO)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAccountStatementReport(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.getAccountStatementReport(startDate, endDate)
                .stream()
                .map(reportRepoMapper::toDomain)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAllAccountStatements() {
        return transactionRepository.getAllAccountStatements()
                .stream()
                .map(reportRepoMapper::toDomain)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAccountStatementReportByUser(LocalDateTime startDate, LocalDateTime endDate, Long userId) {
        return transactionRepository.getAccountStatementReportByUser(startDate, endDate, userId)
                .stream()
                .map(reportRepoMapper::toDomain)
                .toList();
    }
}
