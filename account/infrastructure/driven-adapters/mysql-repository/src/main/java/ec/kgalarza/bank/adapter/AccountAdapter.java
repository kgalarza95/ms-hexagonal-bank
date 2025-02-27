package ec.kgalarza.bank.adapter;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import ec.kgalarza.bank.mapper.AccountRepoMapper;
import ec.kgalarza.bank.model.entity.AccountEntity;
import ec.kgalarza.bank.repository.IAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAdapter implements IAccountRepositoryGateway {

    private final IAccountRepository accountRepository;

    public AccountAdapter(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = AccountRepoMapper.toEntity(account);
        AccountEntity savedEntity = accountRepository.save(entity);
        return AccountRepoMapper.toDTO(savedEntity);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id)
                .map(AccountRepoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(AccountRepoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountRepoMapper::toDTO)
                .toList();
    }
}
