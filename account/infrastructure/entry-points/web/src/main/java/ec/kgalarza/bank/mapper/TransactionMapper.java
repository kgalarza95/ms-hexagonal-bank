package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Transaction;
import ec.kgalarza.bank.dto.TransactionInDTO;
import ec.kgalarza.bank.dto.TransactionOutDTO;

public class TransactionMapper {
    public static Transaction toDomain(TransactionInDTO dto) {
        if (dto == null) return null;

        Transaction transaction = new Transaction();
        transaction.setInitialBalance(dto.getInitialBalance());
        transaction.setTransactionAmount(dto.getTransactionAmount());
        transaction.setAvailableBalance(dto.getAvailableBalance());
        transaction.setTransactionDescription(dto.getTransactionDescription());
        transaction.setAccountId(dto.getAccountId());

        return transaction;
    }

    public static TransactionOutDTO toOutDTO(Transaction transaction) {
        if (transaction == null) return null;

        TransactionOutDTO dto = new TransactionOutDTO();
        dto.setId(transaction.getId());
        dto.setTransactionDate(transaction.getTransactionDate());
        dto.setInitialBalance(transaction.getInitialBalance());
        dto.setTransactionAmount(transaction.getTransactionAmount());
        dto.setAvailableBalance(transaction.getAvailableBalance());
        dto.setTransactionDescription(transaction.getTransactionDescription());

        return dto;
    }
}
