package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

public class SaveCustomerUseCase {

    private final CustomerRepositoryGateway customerRepositoryGateway;

    public SaveCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public Customer execute(Customer entidad) {
        return customerRepositoryGateway.save(entidad);
    }

}
