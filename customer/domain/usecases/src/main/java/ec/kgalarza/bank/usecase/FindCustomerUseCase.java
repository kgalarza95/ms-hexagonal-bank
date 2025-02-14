package ec.kgalarza.bank.usecase;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

import java.util.List;

public class FindCustomerUseCase {

    CustomerRepositoryGateway customerRepositoryGateway;

    public FindCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public List<Customer> findAll() {
        return customerRepositoryGateway.findAll();
    }

    public Customer findById(Long id) {
        return customerRepositoryGateway.findById(id);
    }
}
