package ec.kgalarza.bank.handler;

import ec.kgalarza.bank.FindByIdCustomerUseCase;
import ec.kgalarza.bank.UpdateCustomerUseCase;
import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.dto.CustomerWithIdInDTO;
import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.FindCustomerUseCase;
import ec.kgalarza.bank.SaveCustomerUseCase;
import ec.kgalarza.bank.mapper.ICustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerHandler {

    private final FindCustomerUseCase findCustomerUseCase;
    private final FindByIdCustomerUseCase findByIdCustomerUseCase;
    private final SaveCustomerUseCase saveCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public CustomerHandler(FindCustomerUseCase findCustomerUseCase, FindByIdCustomerUseCase findByIdCustomerUseCase, SaveCustomerUseCase saveCustomerUseCase, UpdateCustomerUseCase updateCustomerUseCase) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.saveCustomerUseCase = saveCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    public List<CustomerOutDTO> findAll() {
        return findCustomerUseCase.execute().stream()
                .map(customer -> ICustomerMapper.INSTANCE.toOutDTO(customer))
                .collect(Collectors.toList());
    }


    public CustomerOutDTO findById(Long id) {
        Customer customer = findByIdCustomerUseCase.execute(id);
        return customer != null ? ICustomerMapper.INSTANCE.toOutDTO(customer) : null;
    }

    public CustomerOutDTO save(CustomerInDTO customerInDTO) {
        Customer customer = ICustomerMapper.INSTANCE.toDomain(customerInDTO);
        return ICustomerMapper.INSTANCE.toOutDTO(saveCustomerUseCase.execute(customer));
    }

    public CustomerOutDTO update(CustomerWithIdInDTO customerInDTO) {
        Customer customer = ICustomerMapper.INSTANCE.toDomain(customerInDTO);
        return ICustomerMapper.INSTANCE.toOutDTO(updateCustomerUseCase.execute(customer));
    }

}
