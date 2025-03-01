package ec.kgalarza.bank.adapter;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;
import ec.kgalarza.bank.mapper.ICustomerRepoMapper;
import ec.kgalarza.bank.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerAdapter implements ICustomerRepositoryGateway {

    private final ICustomerRepository customerRepository;
    private final ICustomerRepoMapper customerRepoMapper;

    public CustomerAdapter(ICustomerRepository customerRepository, ICustomerRepoMapper customerRepoMapper) {
        this.customerRepository = customerRepository;
        this.customerRepoMapper = customerRepoMapper;
    }

    @Override
    public Customer save(Customer customer) {
        return Optional.of(customer)
                .map(customerRepoMapper::toEntity)
                .map(customerRepository::save)
                .map(customerRepoMapper::toDomain)
                .orElseThrow(null);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .map(customerRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Customer findByIdentification(String identification) {
        return customerRepository.findByIdentification(identification)
                .map(customerRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(customerRepoMapper::toDomain)
                .toList();
    }

}
