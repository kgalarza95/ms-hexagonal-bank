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

    IAccountRepository iAccountRepository;

    public AccountAdapter(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = AccountRepoMapper.toEntity(account);
        AccountEntity savedEntity = iAccountRepository.save(entity);
        return AccountRepoMapper.toDTO(savedEntity);
    }

    @Override
    public Account findById(Long id) {
        return iAccountRepository.findById(id)
                .map(AccountRepoMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll()
                .stream()
                .map(AccountRepoMapper::toDTO)
                .toList();
    }
}
