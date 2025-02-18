package ec.kgalarza.bank.adapter;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;
import ec.kgalarza.bank.mapper.CustomerRepoMapper;
import ec.kgalarza.bank.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerAdapter implements CustomerRepositoryGateway {

    ICustomerRepository iCustomerRepository;

    public CustomerAdapter(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return Optional.of(customer)
                .map(CustomerRepoMapper::toEntity)
                .map(iCustomerRepository::save)
                .map(CustomerRepoMapper::toDomain)
                .orElseThrow(null);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id)
                .map(CustomerRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll().stream()
                .map(CustomerRepoMapper::toDomain)
                .toList();
    }
}
