package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.exception.CustomerAlreadyExistsException;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;
import ec.kgalarza.bank.service.IEncryptionService;

public class SaveCustomerUseCase {

    private final ICustomerRepositoryGateway ICustomerRepositoryGateway;
    private final IEncryptionService iEncryptionService;

    public SaveCustomerUseCase(ICustomerRepositoryGateway ICustomerRepositoryGateway, IEncryptionService iEncryptionService) {
        this.ICustomerRepositoryGateway = ICustomerRepositoryGateway;
        this.iEncryptionService = iEncryptionService;
    }

    public Customer execute(Customer entidad) {
        Customer customerExists = ICustomerRepositoryGateway.findByIdentification(entidad.getIdentification());
        if (customerExists != null){
            throw new CustomerAlreadyExistsException("The customer with identification " + entidad.getIdentification() + " already exists.");
        }
        entidad.setPassword(iEncryptionService.encrypt(entidad.getPassword()));
        return ICustomerRepositoryGateway.save(entidad);
    }


}
