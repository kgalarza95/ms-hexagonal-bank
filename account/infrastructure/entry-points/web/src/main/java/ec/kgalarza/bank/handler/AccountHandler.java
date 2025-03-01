package ec.kgalarza.bank.handler;

import com.kgalarza.bank.account.FindAccountUseCase;
import com.kgalarza.bank.account.FindByIdAccountUseCase;
import com.kgalarza.bank.account.SaveAccountUseCase;
import com.kgalarza.bank.entity.Account;

import ec.kgalarza.bank.dto.AccountInDTO;
import ec.kgalarza.bank.dto.AccountOutDTO;
import ec.kgalarza.bank.mapper.IAccountMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHandler {

    private final FindAccountUseCase findAccountUseCase;
    private final FindByIdAccountUseCase findByIdAccountUseCase;
    private final SaveAccountUseCase saveAccountUseCase;
    private final IAccountMapper accountMapper;

    public AccountHandler(FindAccountUseCase findAccountUseCase, FindByIdAccountUseCase findByIdAccountUseCase, SaveAccountUseCase saveAccountUseCase, IAccountMapper accountMapper) {
        this.findAccountUseCase = findAccountUseCase;
        this.findByIdAccountUseCase = findByIdAccountUseCase;
        this.saveAccountUseCase = saveAccountUseCase;
        this.accountMapper = accountMapper;
    }

    public List<AccountOutDTO> findAll() {
        return findAccountUseCase.execute().stream()
                .map(accountMapper::toOutDTO)
                .collect(Collectors.toList());
    }

    public AccountOutDTO findById(Long id) {
        Account account = findByIdAccountUseCase.execute(id);
        return account != null ? accountMapper.toOutDTO(account) : null;
    }

    public AccountOutDTO save(AccountInDTO accountInDTO) {
        Account account = accountMapper.toDomain(accountInDTO);
        return accountMapper.toOutDTO(saveAccountUseCase.execute(account));
    }
}
