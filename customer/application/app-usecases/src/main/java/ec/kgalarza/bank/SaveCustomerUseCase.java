package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.CustomerAlreadyExistsException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;
import ec.kgalarza.bank.service.IEncryptionService;

public class SaveCustomerUseCase {

    private final ICustomerRepositoryGateway customerRepositoryGateway;
    private final IEncryptionService encryptionService;

    public SaveCustomerUseCase(ICustomerRepositoryGateway customerRepositoryGateway, IEncryptionService encryptionService) {
        this.customerRepositoryGateway = customerRepositoryGateway;
        this.encryptionService = encryptionService;
    }

    public Customer execute(Customer customer) {
        Customer customerExists = customerRepositoryGateway.findByIdentification(customer.getIdentification());
        if (customerExists != null){
            throw new CustomerAlreadyExistsException("The customer with identification " + customer.getIdentification() + " already exists.");
        }
        customer.setPassword(encryptionService.encrypt(customer.getPassword()));
        return customerRepositoryGateway.save(customer);
    }
}

