package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Transaction;
import ec.kgalarza.bank.model.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITransactionRepoMapper {

    TransactionEntity toEntity(Transaction dto);

    Transaction toDTO(TransactionEntity entity);
}
