package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.ResourceNotFoundException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;

public class UpdateCustomerUseCase {

    private final ICustomerRepositoryGateway ICustomerRepositoryGateway;

    public UpdateCustomerUseCase(ICustomerRepositoryGateway ICustomerRepositoryGateway) {
        this.ICustomerRepositoryGateway = ICustomerRepositoryGateway;
    }

    public Customer execute(Customer entidad) {
        Customer customerExists = ICustomerRepositoryGateway.findById(entidad.getCustomerId());
        if (customerExists == null) {
            throw new ResourceNotFoundException("Customer with id " + entidad.getCustomerId() + " not found");
        }
        return ICustomerRepositoryGateway.save(entidad);
    }


}
