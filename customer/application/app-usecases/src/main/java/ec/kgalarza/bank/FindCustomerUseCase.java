package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;

import java.util.List;

public class FindCustomerUseCase {

    private final ICustomerRepositoryGateway ICustomerRepositoryGateway;

    public FindCustomerUseCase(ICustomerRepositoryGateway ICustomerRepositoryGateway) {
        this.ICustomerRepositoryGateway = ICustomerRepositoryGateway;
    }

    public List<Customer> execute() {
        List<Customer> customers = ICustomerRepositoryGateway.findAll();
        if (customers == null || customers.isEmpty()) {
            throw new ResourceNotFoundException("No customers found");
        }
        return customers;
    }
}
