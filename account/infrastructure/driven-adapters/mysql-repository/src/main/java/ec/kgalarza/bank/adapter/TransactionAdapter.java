package ec.kgalarza.bank.adapter;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.gateway.TransactionRepositoryGateway;
import ec.kgalarza.bank.mapper.TransactionRepoMapper;
import ec.kgalarza.bank.model.entity.TransactionEntity;
import ec.kgalarza.bank.repository.ITransactionRepository;

import java.util.List;

public class TransactionAdapter implements TransactionRepositoryGateway {

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
}
