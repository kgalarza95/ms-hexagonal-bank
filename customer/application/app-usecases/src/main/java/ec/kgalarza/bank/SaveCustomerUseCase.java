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
        Customer customerExists = customerRepositoryGateway.findByIdentification(entidad.getIdentification());
        if (customerExists != null){
            throw new CustomerAlreadyExistsException("The customer with identification " + entidad.getIdentification() + " already exists.");
        }
        return customerRepositoryGateway.save(entidad);
    }


}
