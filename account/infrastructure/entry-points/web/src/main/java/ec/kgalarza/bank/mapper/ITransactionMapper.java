package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Transaction;
import ec.kgalarza.bank.dto.TransactionInDTO;
import ec.kgalarza.bank.dto.TransactionOutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {

    Transaction toDomain(TransactionInDTO dto);

    TransactionOutDTO toOutDTO(Transaction transaction);
}
