package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.gateway.CustomerRepositoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindCustomerUseCaseTest {
    @Mock
    private CustomerRepositoryGateway customerRepositoryGateway;

    private FindCustomerUseCase findCustomerUseCase;
    private FindByIdCustomerUseCase findByIdCustomerUseCase;

    @BeforeEach
    void setUp() {
        findCustomerUseCase = new FindCustomerUseCase(customerRepositoryGateway);
        findByIdCustomerUseCase = new FindByIdCustomerUseCase(customerRepositoryGateway);
    }

    @Test
    void execute_ShouldReturnListOfCustomers() {
        // Arrange
        List<Customer> expectedCustomers = List.of(
                new Customer("John Doe", "Male", 30, "123456789", "123 Street", "555-1234", 1L, "password1", true),
                new Customer("Jane Doe", "Female", 28, "987654321", "456 Avenue", "555-5678", 2L, "password2", true)
        );
        Mockito.when(customerRepositoryGateway.findAll()).thenReturn(expectedCustomers);

        // Act
        List<Customer> result = findCustomerUseCase.execute();

        // Assert
        Assertions.assertEquals(expectedCustomers, result);
        Mockito.verify(customerRepositoryGateway).findAll();
    }

    @Test
    void findById_ShouldReturnCustomer_WhenCustomerExists() {

        Long customerId = 1L;
        Customer expectedCustomer = new Customer("John Doe", "Male", 30, "123456789", "123 Street", "555-1234", customerId, "password1", true);
        Mockito.when(customerRepositoryGateway.findById(customerId)).thenReturn(expectedCustomer);

        Customer result = findByIdCustomerUseCase.execute(customerId);

        Assertions.assertEquals(expectedCustomer, result);
        Mockito.verify(customerRepositoryGateway).findById(customerId);
    }

    @Test
    void findById_ShouldReturnNull_WhenCustomerDoesNotExist() {
        Long customerId = 99L;
        Mockito.when(customerRepositoryGateway.findById(customerId)).thenReturn(null);

        Customer result = findByIdCustomerUseCase.execute(customerId);

        Assertions.assertNull(result);
        Mockito.verify(customerRepositoryGateway).findById(customerId);
    }
}
