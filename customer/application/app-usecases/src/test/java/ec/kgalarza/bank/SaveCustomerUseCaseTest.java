package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.ICustomerRepositoryGateway;
import ec.kgalarza.bank.service.IEncryptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaveCustomerUseCaseTest {
    @Mock
    private ICustomerRepositoryGateway ICustomerRepositoryGateway;
    @Mock
    private IEncryptionService iEncryptionService;

    private SaveCustomerUseCase saveCustomerUseCase;

    @BeforeEach
    void setUp() {
        saveCustomerUseCase = new SaveCustomerUseCase(ICustomerRepositoryGateway, iEncryptionService);
    }

    @Test
    void execute_ShouldReturnSavedCustomer() {
        Customer customerToSave = new Customer("John Doe", "Male", 30, "123456789", "123 Street", "555-1234", 1L, "password1", true);
        Mockito.when(ICustomerRepositoryGateway.save(customerToSave)).thenReturn(customerToSave);

        Customer result = saveCustomerUseCase.execute(customerToSave);

        Assertions.assertEquals(customerToSave, result);
        Mockito.verify(ICustomerRepositoryGateway).save(customerToSave);
    }
}
