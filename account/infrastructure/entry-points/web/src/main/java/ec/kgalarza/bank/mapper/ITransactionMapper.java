package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Transaction;
import ec.kgalarza.bank.dto.TransactionInDTO;
import ec.kgalarza.bank.dto.TransactionOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {

    @Mapping(target = "account", source = "accountId", qualifiedByName = "mapAccount")
    Transaction toDomain(TransactionInDTO dto);

    @Named("mapAccount")
    default Account mapAccount(Long accountId) {
        if (accountId == null) {
            return null;
        }
        Account account = new Account();
        account.setId(accountId);
        return account;
    }

    TransactionOutDTO toOutDTO(Transaction transaction);
}
