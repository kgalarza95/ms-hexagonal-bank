package ec.kgalarza.bank.mapper;

import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.dto.CustomerWithIdInDTO;
import ec.kgalarza.bank.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer toDomain(CustomerInDTO customerInDTO);
    Customer toDomain(CustomerWithIdInDTO customerInDTO);
    CustomerOutDTO toOutDTO(Customer customer);
}
