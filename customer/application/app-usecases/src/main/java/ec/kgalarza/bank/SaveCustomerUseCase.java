package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

public class SaveCustomerUseCase {

    CustomerRepositoryGateway customerRepositoryGateway;

    public SaveCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public Customer save(Customer entidad) {
        return customerRepositoryGateway.save(entidad);
    }

}
