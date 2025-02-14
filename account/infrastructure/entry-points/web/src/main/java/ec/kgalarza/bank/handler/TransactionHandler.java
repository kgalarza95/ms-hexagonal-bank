package ec.kgalarza.bank.handler;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.usecase.transaction.FindTransactionUseCase;
import com.kgalarza.bank.usecase.transaction.SaveTransactionUseCase;
import ec.kgalarza.bank.dto.TransactionInDTO;
import ec.kgalarza.bank.dto.TransactionOutDTO;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.mapper.TransactionMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionHandler {

    FindTransactionUseCase findTransactionUseCase;
    SaveTransactionUseCase saveTransactionUseCase;

    public TransactionHandler(FindTransactionUseCase findTransactionUseCase, SaveTransactionUseCase saveTransactionUseCase) {
        this.findTransactionUseCase = findTransactionUseCase;
        this.saveTransactionUseCase = saveTransactionUseCase;
    }

    public List<TransactionOutDTO> findAll() {
        return findTransactionUseCase.findAll().stream()
                .map(TransactionMapper::toOutDTO)
                .collect(Collectors.toList());
    }

    public TransactionOutDTO findById(Long id) {
        Transaction transaction = findTransactionUseCase.findById(id);
        return transaction != null ? TransactionMapper.toOutDTO(transaction) : null;
    }

    public TransactionOutDTO save(TransactionInDTO transactionInDTO) {
        Transaction transaction = TransactionMapper.toDomain(transactionInDTO);
        return TransactionMapper.toOutDTO(saveTransactionUseCase.save(transaction));
    }

}
