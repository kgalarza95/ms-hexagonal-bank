package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Transaction;
import ec.kgalarza.bank.model.entity.AccountEntity;
import ec.kgalarza.bank.model.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IAccountRepoMapper {

    AccountEntity toEntity(Account dto);

    @Mapping(target = "transactions", qualifiedByName = "mapTransactions")
    Account toDomain(AccountEntity accountEntity);

    @Mapping(target = "account", ignore = true)
    Transaction toDomain(TransactionEntity transactionEntity);

    @Named("mapTransactions")
    default List<Transaction> mapTransactions(List<TransactionEntity> entities) {
        if (entities == null) return Collections.emptyList();
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
