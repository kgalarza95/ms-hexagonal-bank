package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Transaction;
import ec.kgalarza.bank.model.entity.TransactionEntity;

public class TransactionRepoMapper {

    public static TransactionEntity toEntity(Transaction dto) {
        if (dto == null) {
            return null;
        }
        TransactionEntity entity = new TransactionEntity();
        entity.setId(dto.getId());
        entity.setTransactionDate(dto.getTransactionDate());
        entity.setInitialBalance(dto.getInitialBalance());
        entity.setTransactionAmount(dto.getTransactionAmount());
        entity.setAvailableBalance(dto.getAvailableBalance());
        entity.setTransactionDescription(dto.getTransactionDescription());

        return entity;
    }

    public static Transaction toDTO(TransactionEntity entity) {
        if (entity == null) {
            return null;
        }
        Transaction dto = new Transaction();
        dto.setId(entity.getId());
        dto.setTransactionDate(entity.getTransactionDate());
        dto.setInitialBalance(entity.getInitialBalance());
        dto.setTransactionAmount(entity.getTransactionAmount());
        dto.setAvailableBalance(entity.getAvailableBalance());
        dto.setTransactionDescription(entity.getTransactionDescription());
        return dto;
    }
}
