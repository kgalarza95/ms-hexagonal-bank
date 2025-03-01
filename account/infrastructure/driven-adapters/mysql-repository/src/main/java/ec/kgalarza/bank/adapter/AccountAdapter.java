package ec.kgalarza.bank.adapter;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.gateway.IAccountRepositoryGateway;
import ec.kgalarza.bank.mapper.IAccountRepoMapper;
import ec.kgalarza.bank.model.entity.AccountEntity;
import ec.kgalarza.bank.repository.IAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAdapter implements IAccountRepositoryGateway {

    private final IAccountRepository accountRepository;
    private final IAccountRepoMapper accountRepoMapper;

    public AccountAdapter(IAccountRepository accountRepository, IAccountRepoMapper accountRepoMapper) {
        this.accountRepository = accountRepository;
        this.accountRepoMapper = accountRepoMapper;
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = accountRepoMapper.toEntity(account);
        return accountRepoMapper.toDomain(accountRepository.save(entity));
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id)
                .map(accountRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(accountRepoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountRepoMapper::toDomain)
                .toList();
    }
}
