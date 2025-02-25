package ec.kgalarza.bank.handler;

import com.kgalarza.bank.entity.Transaction;
import com.kgalarza.bank.transaction.FindByIdTransactionUseCase;
import com.kgalarza.bank.transaction.FindTransactionUseCase;
import com.kgalarza.bank.transaction.SaveTransactionUseCase;
import ec.kgalarza.bank.dto.TransactionInDTO;
import ec.kgalarza.bank.dto.TransactionOutDTO;
import ec.kgalarza.bank.mapper.TransactionMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionHandler {

    private final FindByIdTransactionUseCase findByIdTransactionUseCase;
    private final FindTransactionUseCase findTransactionUseCase;
    private final SaveTransactionUseCase saveTransactionUseCase;

    public TransactionHandler(FindByIdTransactionUseCase findByIdTransactionUseCase, FindTransactionUseCase findTransactionUseCase, SaveTransactionUseCase saveTransactionUseCase) {
        this.findByIdTransactionUseCase = findByIdTransactionUseCase;
        this.findTransactionUseCase = findTransactionUseCase;
        this.saveTransactionUseCase = saveTransactionUseCase;
    }

    public List<TransactionOutDTO> findAll() {
        return findTransactionUseCase.execute().stream()
                .map(TransactionMapper::toOutDTO)
                .collect(Collectors.toList());
    }

    public TransactionOutDTO findById(Long id) {
        Transaction transaction = findByIdTransactionUseCase.execute(id);
        return transaction != null ? TransactionMapper.toOutDTO(transaction) : null;
    }

    @Transactional
    public TransactionOutDTO save(TransactionInDTO transactionInDTO) {
        Transaction transaction = TransactionMapper.toDomain(transactionInDTO);
        return TransactionMapper.toOutDTO(saveTransactionUseCase.execute(transaction));
    }

}
