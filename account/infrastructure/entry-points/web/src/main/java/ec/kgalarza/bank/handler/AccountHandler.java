package ec.kgalarza.bank.handler;

import com.kgalarza.bank.account.FindAccountUseCase;
import com.kgalarza.bank.account.SaveAccountUseCase;
import com.kgalarza.bank.entity.Account;

import ec.kgalarza.bank.dto.AccountInDTO;
import ec.kgalarza.bank.dto.AccountOutDTO;
import ec.kgalarza.bank.mapper.AccountMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHandler {

    private final FindAccountUseCase findAccountUseCase;
    private final SaveAccountUseCase saveAccountUseCase;

    public AccountHandler(FindAccountUseCase findAccountUseCase, SaveAccountUseCase saveAccountUseCase) {
        this.findAccountUseCase = findAccountUseCase;
        this.saveAccountUseCase = saveAccountUseCase;
    }

    public List<AccountOutDTO> findAll() {
        return findAccountUseCase.findAll().stream()
                .map(AccountMapper::toOutDTO)
                .collect(Collectors.toList());
    }

    public AccountOutDTO findById(Long id) {
        Account account = findAccountUseCase.findById(id);
        return account != null ? AccountMapper.toOutDTO(account) : null;
    }

    public AccountOutDTO save(AccountInDTO accountInDTO) {
        Account account = AccountMapper.toDomain(accountInDTO);
        return AccountMapper.toOutDTO(saveAccountUseCase.save(account));
    }
}
