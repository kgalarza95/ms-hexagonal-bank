package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;

public class UpdateCustomerUseCase {

    private final ICustomerRepositoryGateway customerRepositoryGateway;

    public UpdateCustomerUseCase(ICustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public Customer execute(Customer entidad) {
        Customer customerExists = customerRepositoryGateway.findById(entidad.getCustomerId());
        if (customerExists == null) {
            throw new ResourceNotFoundException("Customer with id " + entidad.getCustomerId() + " not found");
        }
        return customerRepositoryGateway.save(entidad);
    }
}

