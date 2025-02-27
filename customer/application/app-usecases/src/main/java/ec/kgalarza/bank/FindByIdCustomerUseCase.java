package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;

public class FindByIdCustomerUseCase {

    private final ICustomerRepositoryGateway ICustomerRepositoryGateway;

    public FindByIdCustomerUseCase(ICustomerRepositoryGateway ICustomerRepositoryGateway) {
        this.ICustomerRepositoryGateway = ICustomerRepositoryGateway;
    }

    public Customer execute(Long id) {
        Customer customer = ICustomerRepositoryGateway.findById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        }
        return customer;
    }
}
