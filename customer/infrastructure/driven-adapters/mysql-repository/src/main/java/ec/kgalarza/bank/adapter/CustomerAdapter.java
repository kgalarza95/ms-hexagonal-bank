package ec.kgalarza.bank.adapter;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;
import ec.kgalarza.bank.mapper.CustomerRepoMapper;
import ec.kgalarza.bank.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerAdapter implements ICustomerRepositoryGateway {

    private final ICustomerRepository customerRepository;

    public CustomerAdapter(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return Optional.of(customer)
                .map(CustomerRepoMapper::toEntity)
                .map(customerRepository::save)
                .map(CustomerRepoMapper::toDomain)
                .orElseThrow(null);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Customer findByIdentification(String identification) {
        return customerRepository.findByIdentification(identification)
                .map(CustomerRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerRepoMapper::toDomain)
                .toList();
    }

}
