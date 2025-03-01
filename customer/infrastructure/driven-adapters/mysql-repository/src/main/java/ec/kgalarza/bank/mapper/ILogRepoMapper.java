package ec.kgalarza.bank.mapper;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.entity.CustomerEntity;
import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.entity.LogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILogRepoMapper {

    Log toDomain(LogEntity logEntity);

    LogEntity toEntity(Log log);
}
