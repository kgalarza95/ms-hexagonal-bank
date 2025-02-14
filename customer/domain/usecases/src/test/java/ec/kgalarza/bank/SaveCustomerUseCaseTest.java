package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;
import ec.kgalarza.bank.usecase.SaveCustomerUseCase;
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
    private CustomerRepositoryGateway customerRepositoryGateway;

    private SaveCustomerUseCase saveCustomerUseCase;

    @BeforeEach
    void setUp() {
        saveCustomerUseCase = new SaveCustomerUseCase(customerRepositoryGateway);
    }

    @Test
    void save_ShouldReturnSavedCustomer() {
        // Arrange
        Customer customerToSave = new Customer("John Doe", "Male", 30, "123456789", "123 Street", "555-1234", 1L, "password1", true);
        Mockito.when(customerRepositoryGateway.save(customerToSave)).thenReturn(customerToSave);

        // Act
        Customer result = saveCustomerUseCase.save(customerToSave);

        // Assert
        Assertions.assertEquals(customerToSave, result);
        Mockito.verify(customerRepositoryGateway).save(customerToSave);
    }
}
