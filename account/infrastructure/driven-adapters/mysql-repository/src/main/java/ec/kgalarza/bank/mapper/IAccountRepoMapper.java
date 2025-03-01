package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Account;
import ec.kgalarza.bank.model.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAccountRepoMapper {

    AccountEntity toEntity(Account dto);

    Account toDomain(AccountEntity entity);
}
