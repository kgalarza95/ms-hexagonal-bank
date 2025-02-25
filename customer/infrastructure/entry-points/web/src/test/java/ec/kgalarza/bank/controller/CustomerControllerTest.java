package ec.kgalarza.bank.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.dto.CustomerWithIdInDTO;
import ec.kgalarza.bank.handler.CustomerHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerHandler customerHandler;

    private CustomerOutDTO customerOutDTO;
    private CustomerInDTO customerInDTO;
    private CustomerWithIdInDTO customerWithIdInDTO;

    @BeforeEach
    void setUp() {
        customerOutDTO = new CustomerOutDTO();
        customerOutDTO.setCustomerId(1L);
        customerOutDTO.setName("John Doe");
        customerOutDTO.setGender("Male");
        customerOutDTO.setAge(30);
        customerOutDTO.setIdentification("123456789");
        customerOutDTO.setAddress("123 Main St");
        customerOutDTO.setPhone("5551234567");
        customerOutDTO.setPassword("securePass");
        customerOutDTO.setStatus(true);

        customerInDTO = new CustomerInDTO();
        customerInDTO.setName("John Doe");
        customerInDTO.setGender("Male");
        customerInDTO.setAge(30);
        customerInDTO.setIdentification("123456789");
        customerInDTO.setAddress("123 Main St");
        customerInDTO.setPhone("5551234567");
        customerInDTO.setPassword("securePass");
        customerInDTO.setStatus(true);

        customerWithIdInDTO = new CustomerWithIdInDTO();
        customerWithIdInDTO.setCustomerId(1L);
        customerWithIdInDTO.setName("John Doe");
        customerWithIdInDTO.setGender("Male");
        customerWithIdInDTO.setAge(30);
        customerWithIdInDTO.setIdentification("123456789");
        customerWithIdInDTO.setAddress("123 Main St");
        customerWithIdInDTO.setPhone("5551234567");
        customerWithIdInDTO.setPassword("securePass");
        customerWithIdInDTO.setStatus(true);
    }

    @Test
    void whenFindAll_thenReturnCustomerList() {
        List<CustomerOutDTO> customers = List.of(customerOutDTO);
        when(customerHandler.findAll()).thenReturn(customers);

        ResponseEntity<List<CustomerOutDTO>> response = customerController.findAll();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());

        verify(customerHandler, times(1)).findAll();
    }

    @Test
    void whenFindById_thenReturnCustomer() {
        when(customerHandler.findById(1L)).thenReturn(customerOutDTO);

        ResponseEntity<CustomerOutDTO> response = customerController.findById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getCustomerId());
        assertEquals("John Doe", response.getBody().getName());

        verify(customerHandler, times(1)).findById(1L);
    }

    @Test
    void whenSave_thenReturnCreatedCustomer() {
        when(customerHandler.save(any(CustomerInDTO.class))).thenReturn(customerOutDTO);

        ResponseEntity<CustomerOutDTO> response = customerController.save(customerInDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("John Doe", response.getBody().getName());

        verify(customerHandler, times(1)).save(any(CustomerInDTO.class));
    }

    @Test
    void whenUpdate_thenReturnUpdatedCustomer() {
        when(customerHandler.update(any(CustomerWithIdInDTO.class))).thenReturn(customerOutDTO);

        ResponseEntity<CustomerOutDTO> response = customerController.update(customerWithIdInDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("John Doe", response.getBody().getName());

        verify(customerHandler, times(1)).update(any(CustomerWithIdInDTO.class));
    }


}
