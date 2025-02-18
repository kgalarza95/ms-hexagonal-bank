package ec.kgalarza.bank;

import ec.kgalarza.bank.config.TestConfiguration;
import ec.kgalarza.bank.entity.CustomerEntity;
import ec.kgalarza.bank.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
    @Autowired
    private ICustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();

        CustomerEntity customer = new CustomerEntity(
                "John Doe",
                "Male",
                30,
                "123456789",
                "123 Main St",
                "555-1234",
                null,
                "securePass",
                true
        );

        customerRepository.save(customer);
    }

    @Test
    void whenFindById_thenReturnCustomer() {
        CustomerEntity customer = customerRepository.findAll().get(0);
        Long customerId = customer.getCustomerId();

        CustomerEntity foundCustomer = customerRepository.findById(customerId).orElse(null);

        assertNotNull(foundCustomer);
        assertEquals(customerId, foundCustomer.getCustomerId());
        assertEquals("John Doe", foundCustomer.getName());
        assertEquals("Male", foundCustomer.getGender());
        assertEquals(30, foundCustomer.getAge());
        assertEquals("123456789", foundCustomer.getIdentification());
        assertEquals("123 Main St", foundCustomer.getAddress());
        assertEquals("555-1234", foundCustomer.getPhone());
        assertEquals("securePass", foundCustomer.getPassword());
        assertTrue(foundCustomer.isStatus());
    }
}
