package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.CustomerAlreadyExistsException;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

import java.util.Optional;

public class UpdateCustomerUseCase {

    private final CustomerRepositoryGateway customerRepositoryGateway;

    public UpdateCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
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
