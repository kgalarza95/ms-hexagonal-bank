package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;

import java.util.List;

public class FindByIdCustomerUseCase {

    private final CustomerRepositoryGateway customerRepositoryGateway;

    public FindByIdCustomerUseCase(CustomerRepositoryGateway customerRepositoryGateway) {
        this.customerRepositoryGateway = customerRepositoryGateway;
    }

    public Customer execute(Long id) {
        return customerRepositoryGateway.findById(id);
    }
}
