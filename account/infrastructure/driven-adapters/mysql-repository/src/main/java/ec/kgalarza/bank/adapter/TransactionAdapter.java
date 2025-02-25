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

    ITransactionRepository iTransactionRepository;

    public TransactionAdapter(ITransactionRepository iTransactionRepository) {
        this.iTransactionRepository = iTransactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = TransactionRepoMapper.toEntity(transaction);
        return TransactionRepoMapper.toDTO(iTransactionRepository.save(transactionEntity));
    }

    @Override
    public Transaction findById(Long id) {
        return iTransactionRepository.findById(id)
                .map(TransactionRepoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return iTransactionRepository.findAll()
                .stream()
                .map(TransactionRepoMapper::toDTO)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAccountStatementReport(LocalDateTime startDate, LocalDateTime endDate) {
        return iTransactionRepository.getAccountStatementReport(startDate, endDate)
                .stream()
                .map(ReportRepoMapper::toDomain)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAllAccountStatements() {
        return iTransactionRepository.getAllAccountStatements()
                .stream()
                .map(ReportRepoMapper::toDomain)
                .toList();
    }

    @Override
    public List<AccountStatementReport> getAccountStatementReportByUser(LocalDateTime startDate, LocalDateTime endDate, Long userId) {
        return iTransactionRepository.getAccountStatementReportByUser(startDate, endDate, userId)
                .stream()
                .map(ReportRepoMapper::toDomain)
                .toList();
    }
}
