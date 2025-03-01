package ec.kgalarza.bank.mapper;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerRepoMapper {

    Customer toDomain(CustomerEntity client);

    CustomerEntity toEntity(Customer customer);
}
