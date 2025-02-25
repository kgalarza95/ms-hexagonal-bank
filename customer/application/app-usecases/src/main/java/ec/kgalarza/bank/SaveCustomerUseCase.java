package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.CustomerAlreadyExistsException;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

import java.util.Objects;
import java.util.Optional;

public class SaveCustomerUseCase {

    private final CustomerRepositoryGateway customerRepositoryGateway;

    public SaveCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public Customer execute(Customer entidad) {
        return Optional.ofNullable(customerRepositoryGateway.findByIdentification(entidad.getIdentification()))
                .filter(existingCustomer -> existingCustomer == null)
                .map(existingCustomer -> customerRepositoryGateway.save(entidad))
                .orElseThrow(() -> new CustomerAlreadyExistsException("The customer with identification " + entidad.getIdentification() + " already exists."));
    }


}
