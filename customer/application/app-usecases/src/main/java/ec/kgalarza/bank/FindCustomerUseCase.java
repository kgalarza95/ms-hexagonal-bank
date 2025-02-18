package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

import java.util.List;

public class FindCustomerUseCase {

    private final CustomerRepositoryGateway customerRepositoryGateway;

    public FindCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public List<Customer> execute() {
        return customerRepositoryGateway.findAll();
    }

}
