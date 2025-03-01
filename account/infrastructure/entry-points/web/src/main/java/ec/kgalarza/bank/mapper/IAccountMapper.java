package ec.kgalarza.bank.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.kgalarza.bank.entity.Account;
import ec.kgalarza.bank.dto.AccountInDTO;
import ec.kgalarza.bank.dto.AccountOutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface IAccountMapper {

    Account toDomain(AccountInDTO dto);
    AccountOutDTO toOutDTO(Account account);
}
