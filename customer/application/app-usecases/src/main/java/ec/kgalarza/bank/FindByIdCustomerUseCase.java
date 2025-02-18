package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

import java.util.List;

public class FindByIdCustomerUseCase {

    private final CustomerRepositoryGateway customerRepositoryGateway;

    public FindByIdCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public Customer execute(Long id) {
        Customer customer = customerRepositoryGateway.findById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        }
        return customer;
    }
}
