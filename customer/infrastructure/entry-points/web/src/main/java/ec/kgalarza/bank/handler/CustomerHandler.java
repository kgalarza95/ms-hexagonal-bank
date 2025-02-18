package ec.kgalarza.bank.handler;

import ec.kgalarza.bank.FindByIdCustomerUseCase;
import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.mapper.CustomerMapper;
import ec.kgalarza.bank.FindCustomerUseCase;
import ec.kgalarza.bank.SaveCustomerUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerHandler {

    private final FindCustomerUseCase findCustomerUseCase;
    private final FindByIdCustomerUseCase  findByIdCustomerUseCase;
    private final SaveCustomerUseCase saveCustomerUseCase;

    public CustomerHandler(FindCustomerUseCase findCustomerUseCase, FindByIdCustomerUseCase findByIdCustomerUseCase, SaveCustomerUseCase saveCustomerUseCase) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.saveCustomerUseCase = saveCustomerUseCase;
    }

    public List<CustomerOutDTO> findAll() {
        return findCustomerUseCase.execute().stream()
                .map(CustomerMapper::toOutDTO)
                .collect(Collectors.toList());
    }

    public CustomerOutDTO findById(Long id) {
        Customer customer = findByIdCustomerUseCase.execute(id);
        return customer != null ? CustomerMapper.toOutDTO(customer) : null;
    }

    public CustomerOutDTO save(CustomerInDTO customerInDTO) {
        Customer customer = CustomerMapper.toDomain(customerInDTO);
        return CustomerMapper.toOutDTO(saveCustomerUseCase.execute(customer));
    }

}
