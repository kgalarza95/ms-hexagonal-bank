package ec.kgalarza.bank.controller;

import ec.kgalarza.bank.dto.AccountInDTO;
import ec.kgalarza.bank.dto.AccountOutDTO;
import ec.kgalarza.bank.handler.AccountHandler;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountHandler accountHandler;

    private AccountOutDTO accountOutDTO;
    private AccountInDTO accountInDTO;

    @BeforeEach
    void setUp() {
        accountOutDTO = new AccountOutDTO(
                1L,
                "123456",
                "SAVINGS",
                BigDecimal.valueOf(1000.0),
                true,
                1L
        );

        accountInDTO = new AccountInDTO(
                "123456",
                "SAVINGS",
                BigDecimal.valueOf(1000.0),
                true,
                1L
        );
    }


    @Test
    void whenFindAll_thenReturnAccountList() {
        List<AccountOutDTO> accounts = List.of(accountOutDTO);
        when(accountHandler.findAll()).thenReturn(accounts);

        ResponseEntity<List<AccountOutDTO>> response = accountController.findAll();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("123456", response.getBody().get(0).accountNumber());

        verify(accountHandler, times(1)).findAll();
    }

    @Test
    void whenFindById_thenReturnAccount() {
        when(accountHandler.findById(1L)).thenReturn(accountOutDTO);

        ResponseEntity<AccountOutDTO> response = accountController.findById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("123456", response.getBody().accountNumber());
        assertEquals(1L, response.getBody().id());

        verify(accountHandler, times(1)).findById(1L);
    }

    @Test
    void whenFindById_thenReturnNotFound() {
        when(accountHandler.findById(1L)).thenReturn(null);

        ResponseEntity<AccountOutDTO> response = accountController.findById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(accountHandler, times(1)).findById(1L);
    }

    @Test
    void whenSave_thenReturnCreatedAccount() {
        when(accountHandler.save(any(AccountInDTO.class))).thenReturn(accountOutDTO);

        ResponseEntity<AccountOutDTO> response = accountController.save(accountInDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("123456", response.getBody().accountNumber());

        verify(accountHandler, times(1)).save(any(AccountInDTO.class));
    }
}
