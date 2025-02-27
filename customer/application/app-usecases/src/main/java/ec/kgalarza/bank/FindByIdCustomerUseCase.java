package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;

public class FindByIdCustomerUseCase {

    private final ICustomerRepositoryGateway customerRepositoryGateway;

    public FindByIdCustomerUseCase(ICustomerRepositoryGateway customerRepositoryGateway) {
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
