package ec.kgalarza.bank.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerCreationWithConstructor() {
        Long customerId = 12345L;
        String password = "password123";
        boolean status = true;

        Customer customer = new Customer(customerId, password, status);

        assertEquals(customerId, customer.getCustomerId());
        assertEquals(password, customer.getPassword());
        assertTrue(customer.isStatus());
    }

    @Test
    public void testCustomerCreationWithFullConstructor() {
        String name = "Kevin Galarza";
        String gender = "Male";
        Integer age = 30;
        String identification = "123456789";
        String address = "123 Main St";
        String phone = "987654321";
        Long customerId = 12345L;
        String password = "password123";
        boolean status = true;

        Customer customer = new Customer(name, gender, age, identification, address, phone, customerId, password, status);

        assertEquals(name, customer.getName());
        assertEquals(gender, customer.getGender());
        assertEquals(age, customer.getAge());
        assertEquals(identification, customer.getIdentification());
        assertEquals(address, customer.getAddress());
        assertEquals(phone, customer.getPhone());
        assertEquals(customerId, customer.getCustomerId());
        assertEquals(password, customer.getPassword());
        assertTrue(customer.isStatus());
    }

    @Test
    public void testSettersAndGetters() {
        Customer customer = new Customer();

        customer.setCustomerId(12345L);
        customer.setPassword("password123");
        customer.setStatus(true);

        assertEquals(12345L, customer.getCustomerId());
        assertEquals("password123", customer.getPassword());
        assertTrue(customer.isStatus());
    }

    @Test
    public void testDefaultConstructor() {
        Customer customer = new Customer();

        assertNull(customer.getCustomerId());
        assertNull(customer.getPassword());
        assertFalse(customer.isStatus());
    }
}
