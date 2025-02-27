package ec.kgalarza.bank;

import ec.kgalarza.bank.config.TestConfiguration;
import ec.kgalarza.bank.model.entity.AccountEntity;
import ec.kgalarza.bank.repository.IAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest {

    @Autowired
    private IAccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository.deleteAll();

        AccountEntity account = new AccountEntity();
        account.setAccountNumber("123456");
        account.setAccountType("Checking");
        account.setOnlineBalance(BigDecimal.valueOf(1000.0));
        account.setStatus(true);
        account.setCustomerId(1L);
        accountRepository.save(account);
    }

    @Test
    void whenFindById_thenReturnAccount() {
        AccountEntity account = accountRepository.findById(1L).orElse(null);

        assertNotNull(account);
        assertEquals(1L, account.getId());
        assertEquals("123456", account.getAccountNumber());
        assertEquals("Checking", account.getAccountType());
        assertEquals(1000.0, account.getOnlineBalance());
        assertEquals(true, account.isStatus());
        assertEquals(1L, account.getCustomerId());
    }
}
