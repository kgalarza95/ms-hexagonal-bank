package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.CustomerEntity;
import ec.kgalarza.bank.repository.ICustomerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ContextConfiguration(classes = TestConfiguration.class)
//@DataJpaTest
public class CustomerRepositoryTest {

//    @Autowired
//    private ICustomerRepository customerRepository;
//
//    @Test
//    public void testSaveCustomer() {
//        CustomerEntity customer = new CustomerEntity("John", "Male", 30, "123456789", "1234 Main St", "123-456-7890", 1L, "password", true);
//
//        CustomerEntity savedCustomer = customerRepository.save(customer);
//
//        assertNotNull(savedCustomer);
//        assertNotNull(savedCustomer.getCustomerId());
//        assertEquals("John", savedCustomer.getName());
//    }
//
//    @Test
//    public void testFindCustomerById() {
//        CustomerEntity customer = new CustomerEntity("Jane", "Female", 28, "987654321", "5678 Main St", "987-654-3210", 2L, "password", true);
//        customerRepository.save(customer);
//
//        CustomerEntity foundCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
//
//        assertNotNull(foundCustomer);
//        assertEquals("Jane", foundCustomer.getName());
//    }
}
