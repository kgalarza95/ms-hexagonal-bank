package ec.kgalarza.bank.gateway;

import ec.kgalarza.bank.entity.Customer;

import java.util.List;

public interface CustomerRepositoryGateway {

    Customer save(Customer customer);
    Customer findById(Long id);
    Customer findByIdentification(String identification);
    List<Customer> findAll();
}
